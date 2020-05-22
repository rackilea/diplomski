public static final Connection close(Connection con)
throws SQLException
{
    con.close();
    return null;
}

public static final Connection quietClose(Connection con)
{
    if (con != null) {
        try {
            con.close();
        }
        catch (Exception e) {
        }
    }
    return null;
}