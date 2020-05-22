// 0. create some test data
String[] letters = new String[] { "G", "o", "r", "d" };
//
// 1. create temporary table
Statement s = conn.createStatement();
s.executeUpdate("CREATE TABLE #tmp (seq INT IDENTITY PRIMARY KEY, letter VARCHAR(1))");
//
// 2. populate temporary table with letters to look up
PreparedStatement ps = conn.prepareStatement("INSERT INTO #tmp (letter) VALUES (?)");
for (String letter : letters) {
    ps.setString(1, letter);
    ps.addBatch();
}
ps.executeBatch();
//
// 3. use anonymous code block to pass table-valued parameter to stored procedure
String sql = 
          "SET NOCOUNT ON; "
        + "DECLARE @tvp dbo.LetterListTableType; "
        + "INSERT INTO @tvp (seq, letter) SELECT seq, letter FROM #tmp; "
        + "EXEC dbo.GetPhonetic @tvp; ";
ResultSet rs = s.executeQuery(sql);
while (rs.next()) {
    System.out.printf("%s -> %s%n", rs.getString("letter"), rs.getString("word"));
}