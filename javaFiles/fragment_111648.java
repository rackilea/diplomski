Connection con DriverManager.getConnection("jdbc:driver:host","myLogin","myPassword");    
Statement statement = con.createStatement();
ResultSet result = statement.executeQuery("SELECT COUNT(DISTINCT columnName) AS columnDistinctCount FROM tableName;");

int uniqueEntryCount = result.getInt("columnDistinctCount");

if (uniqueEntryCount > 0) {
    methodOne();
else {
    methodTwo();