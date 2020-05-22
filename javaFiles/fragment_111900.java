try {
    Class.forName("com.sap.db.jdbc.Driver");

    String url = "jdbc:sap://xx.x.x.xxx:30015/?databaseName=DBNAME";
    String user = "user";
    String password = "password";

    Connection cn = java.sql.DriverManager.getConnection(url, user, password);

    ResultSet rs = cn.createStatement().executeQuery("CALL MY_SCHEMA.STORED_PROC");

    // ... do whatever with the results ...

} catch (Exception e) {
    e.printStackTrace();
}