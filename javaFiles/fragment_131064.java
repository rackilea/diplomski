public static void C()
throws SQLException
{
    Connection con = DriverManager.getConnection();
    try {
        .... // code

        // done with the connection
        con.close();
        con = null;
    }
    finally {
        if (con != null) {
            try {
                con.close();
            }
            catch (Exception e) {
                // Eat it to avoid masking any exception that
                // got us here
            }
        }
    }
}