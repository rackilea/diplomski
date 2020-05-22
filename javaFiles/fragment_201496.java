public static Connection createConnection() {
    Connection conn=null;
    try{
        Class.forName(DRIVER);
        conn =  DriverManager.getConnection(DBURL,"root","toor");
    }catch(Exception e){}
    return conn;
}