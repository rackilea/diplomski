public static void C()
throws SQLException
{
    Connection con = DriverManager.getConnection();
    try {
        .... // code

        // done with the connection
        con = JDBCHelper.close(con);      // <== This one *allows* any exception that occurs
    }
    finally {
        con = JDBCHelper.quietClose(con); // <== This one *eats* any exception that occurs
    }
}