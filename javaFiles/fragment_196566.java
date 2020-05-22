public Connection getcon(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        String unicode="useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
        return DriverManager.getConnection("jdbc:mysql://localhost:15501/duckdb?"+unicode, "root", "_PWD");
    }catch(Exception ex){
        System.out.println(ex.getMessage());
        System.out.println("couldn't connect!");
        throw new RuntimeException(ex);
    }
}