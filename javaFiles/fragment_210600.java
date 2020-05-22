Connection connection = null;
try{
    Class.forName("org.postgresql.Driver");
    String connectionString = "jdbc:postgresql://" + dbhost + ":" + dbport + "/" + dbname;
    connection = DriverManager.getConnection(connectionString, dbuser, dbpassword)
}catch (Exception e){
    //...
}