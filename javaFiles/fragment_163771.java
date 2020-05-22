import java.sql.*;

public class ConnectionTest {

private static Connection con = null;

public static Connection abrirBanco(){
    Connection con;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "welcome");
        System.out.println("conectando");
        return con;
    }
    catch(ClassNotFoundException cnfe){
        System.out.println("driver nao encontrado: " + cnfe.getMessage());
        return null;
    }
    catch(SQLException sql){
        System.out.println("SQLException: " + sql.getMessage());
        System.out.println("SQLState: " + sql.getSQLState());
        System.out.println("Erro: " + sql.getErrorCode());
        System.out.println("StackTrace: " + sql.getStackTrace());
        return null;
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        return null;
    }
}

public static void fecharBDcon(){
    try{
        con.close();
    }
    catch(Exception e){
        System.out.println("erro ao fechar o banco" + e.getMessage());
    }
}
public static void main(String arr[])
{
    System.out.println("Making connection..");
    Connection connection = ConnectionTest.abrirBanco();
    System.out.println("Connection made...");
}
}