connect = DriverManager.getConnection(...)

try
{
    // use connection
}
finally
{
    try
    {
        connect.close()
    }
    catch (SQLException e)
    {
        // log e
    }
}