package h2test;

import java.sql.*;
import java.time.OffsetDateTime;

public class H2testMain {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test")) {
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE TEST (ID INT PRIMARY KEY, TWTZ TIMESTAMP WITH TIME ZONE)");
            st.execute("INSERT INTO TEST (ID, TWTZ) VALUES (1, '1981-02-03 19:20:21-02:00')");
            ResultSet rs = st.executeQuery("SELECT TWTZ FROM TEST WHERE ID=1");
            rs.next();
            OffsetDateTime odt = rs.getObject(1, OffsetDateTime.class);
            System.out.println(odt.getClass().getName());  // java.time.OffsetDateTime
            System.out.println(odt.toString());  // 1981-02-03T19:20:21-02:00
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

}