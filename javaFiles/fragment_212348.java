String url = "jdbc:mysql://localhost:3306/mydb?user=myusername&password=mypassword";
String driver = "com.mysql.jdbc.Driver";
String tableName = "mytable";   
String[] columnNames = {'col1', 'col2', 'col3'}; //Columns I want to write to 
TableDesc tableDesc = new TableDesc( tableName );

JDBCScheme dbScheme = new JDBCScheme( columnNames );
Tap dbOutputTap = new JDBCTap( url, driver, tableDesc, dbScheme );