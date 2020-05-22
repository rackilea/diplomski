...
ResultSet result = stat.executeQuery("SELECT * FROM Test");  
while(result.next()) {  
    System.out.println(result.getString("Name"));  
    System.out.println(result.getString("Id"));
}
stat.execute("DROP TABLE Test");