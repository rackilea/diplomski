public class Main {

    private static Connection mysql;

    public static void main(String[] args) {
        connect();
        //...
    }

    private static void connect(){
            Class.forName("com.mysql.jdbc.Driver");
            String connectionStringURL = "jdbc:mysql://us-cdbr-azure-west-b.cleardb.com:3306/database";
            mysql = DriverManager.getConnection(connectionStringURL, "username", "password");
        if(mysql == null){
            System.out.println("Connection Failed");
        }else{
            System.out.println("Success");
        }
    }

//...

}