public class DatabaseUtils
{
    public static void close(Statement s)
    {
        try
        {
            if (s != null)
            {
                s.close();
            }
        }
        catch (SQLException e)
        {
            // log or report in someway
            e.printStackTrace();
        }
    }

    // similar for ResultSet and Connection
}