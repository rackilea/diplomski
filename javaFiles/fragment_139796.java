import java.sql.*;

public class jdbcMsAccess {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};" + 
                    "Dbq=C:\\__tmp\\Database1.accdb;");
            Date date = new Date();
            PreparedStatement s = conn.prepareStatement(
                    "INSERT INTO tblBorrows(DateIn) VALUES (?)");
            s.setDate(1, new java.sql.Date(date.getTime()));
            s.execute();
            s.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }
}