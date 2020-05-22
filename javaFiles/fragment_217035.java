import java.io.*;
import java.sql.*;
import oracle.jdbc.*;

public class DBQC {
   public static void main(String[] args) {
   try {
      Connection con=null;
      Class.forName("oracle.jdbc.OracleDriver");
      String connStr = "jdbc:oracle:thin:scott/tiger@//dbhost:1521/dbsrvc";
      con=DriverManager.getConnection(connStr);
      if(con != null)
      {
         System.out.println("Connection succeeded");

         String dequeueQuery = "DECLARE " +
            " names namesarray;" +
            "   total integer;" +
            "   BEGIN " +
            "   names := namesarray('Kavita', 'Pritam', 'Ayan', 'Rishav', 'Aziz'); " +
            "   ? := names;"+
            " END;";

         CallableStatement cstmt = null;
         con.setAutoCommit(false);
         cstmt =(OracleCallableStatement)con.prepareCall(dequeueQuery);

         cstmt.registerOutParameter(1, OracleTypes.ARRAY,"NAMESARRAY");
         boolean b = cstmt.execute();
         Array arr = cstmt.getArray(1);

         String[] recievedArray = (String[]) arr.getArray();
         for (int i = 0; i < recievedArray.length; i++)
             System.out.println(recievedArray[i]);

         con.commit();
      }
      con.close();
    } catch(Exception e){e.printStackTrace();}
    }
}