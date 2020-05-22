Connection con;
Statement st;
ResultSet rs;

try {
  Class.forName("com.mysql.jdbc.Driver");
  con = DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/dbname",
      "dbuser",
      "bdpass"
  );

  st = con.createStatement();

  String sql = "select * from table";
  rs = st.executeQuery(sql);
  ResultSetMetaData metaData = rs.getMetaData();
  int rowCount = metaData.getColumnCount();

  boolean isMyColumnPresent = false;
  String myColumnName = "myColumnName";
  for (int i = 1; i <= rowCount; i++) {
    if (myColumnName.equals(metaData.getColumnName(i))) {
      isMyColumnPresent = true;
    }
  }

  if (!isMyColumnPresent) {
    String myColumnType = "some type";
    st.executeUpdate("ALTER TABLE table ADD " + myColumnName + " " + myColumnType);
  }
} catch (Exception e) {
  e.printStackTrace();
}