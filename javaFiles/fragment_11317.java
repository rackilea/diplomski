import java.sql.*;

public class JDBCQuery {
    public static void main( String args[] )
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};" + 
                    "Dbq=C:\\Users\\Public\\Database1.accdb;");
            String RoomTypeToMatch = "suite";
            PreparedStatement s = conn.prepareStatement(
                    "SELECT Room_No, Room_Type " +
                    "FROM Room WHERE Room_Type LIKE ?"
                    );
            s.setString(1, "%" + RoomTypeToMatch + "%");
            s.execute();
            ResultSet rs = s.getResultSet();
            if (rs!=null)
            {
                while (rs.next())
                {
                    System.out.println("[Room_No]: " + rs.getString(1) +
                            ", [Room_Type]: " + rs.getString(2));
                }
            }
            s.close();
            conn.close();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }
}