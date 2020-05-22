import java.sql.*;

class DoQuery {

    public static void main (String[] args) {
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=AdventureWorks;integratedSecurity=true;";
            Connection conn = DriverManager.getConnection(url,"","");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT CONVERT(VARCHAR(8),(select TOP 1 LBD=latest_date FROM some_table WHERE latest_date < GETDATE() ORDER BY latest_date DESC), 112) AS [YYYYMMDD]");
            while ( rs.next() ) {
                String myDate = rs.getString("YYYYMMDD");
                System.out.println(myDate);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}