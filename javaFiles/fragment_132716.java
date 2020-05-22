import java.sql.*;
import org.joda.time.*;

public class JDBCQuery {
    public static void main(String args[]) {
        Connection conn = null;
        PreparedStatement s = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection(
                    "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};" + 
                    "DBQ=C:\\Users\\Public\\Database1.accdb;");

            LocalDate requestedArrivalDate = LocalDate.parse("2013-10-12");
            LocalDate requestedDepartureDate = LocalDate.parse("2013-10-21");

            s = conn.prepareStatement(
                    "SELECT BookingID, RmID FROM Booking WHERE BookDepartureDate > ? AND BookArrivalDate < ?");
            s.setDate(1, new java.sql.Date(requestedArrivalDate.toDate().getTime()));
            s.setDate(2, new java.sql.Date(requestedDepartureDate.toDate().getTime()));
            ResultSet rs = s.executeQuery();

            System.out.println(String.format("Requested arrival: %s", requestedArrivalDate.toString()));
            System.out.println(String.format("Requested departure: %s", requestedDepartureDate.toString()));
            System.out.println("The following bookings conflict with that request...");
            if (rs!=null) {
                while (rs.next()) {
                    System.out.println(String.format("BookingID: %d, RmId: %d", rs.getInt("BookingID"), rs.getInt("RmID")) );
                }
            }
            System.out.println("(end of list)");

        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
}