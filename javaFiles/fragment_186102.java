import java.sql.*;

class TestConnection 
{
    public static void main(String args[])
    {
        int stno = Integer.parseInt(args[0]);
        String name = args[1];
        String course = args[2];
        double fees = Double.parseDouble(args[3]);

        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = 
                DriverManager.getConnection("jdbc:odbc:ram","myuser","myuser");
            PreparedStatement st = 
                con.prepareStatement("insert into student values(?, ?, ?, ?)");
            st.setInt(1, stno);
            st.setString(2, name);
            st.setString(3, course);
            st.setDouble(4, fees);
            // executeUpdate returns the number of rows inserted/updated/deleted.
            int count = st.executeUpdate();
            System.out.println(count + " row(s) inserted.");
            con.close();
        }
        catch(Exception P)
        {
            P.printStackTrace();
        }
    }
}