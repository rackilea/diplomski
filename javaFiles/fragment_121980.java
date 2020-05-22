Connection a = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Vince\\Desktop\\Teams.accdb");
Statement s = a.createStatement();
String sqlQuery = "SELECT PlayerID, PlayerName, TeamID " + "FROM PLAYER"+"'";
ResultSet rs = s.executeQuery(sqlQuery);
while(rs.next()){
System.out.println("Connected to DB & found Data!!!");
}