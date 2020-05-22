Statement statement1 = connection.createStatement();
Statement statement2 = connection.createStatement();

ResultSet resultSet1 = statement1.executeQuery("SELECT username FROM users");
while(resultSet1.next()){
...
    statement2.executeUpdate("UPDATE users ..."));
}