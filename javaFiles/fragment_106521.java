public Connection getConnection(){
    Connection con=null;
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "TEST";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "password";

    try {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(url+dbName,userName,password);
        System.out.println("CONNECTION ESTABLISHED.");

    } catch (Exception e) {
        System.out.println("CONNECTION COULD NOT BE ESTABLISHED.");
        e.printStackTrace();
    }

    return con;

}