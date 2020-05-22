try {

    Class.forName("com.mysql.jdbc.Driver").newInstance();
    sqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","usr","pwd");

}
catch(Exception e) {
    e.printStackTrace();
    logger.error("unable to create database connection");
}