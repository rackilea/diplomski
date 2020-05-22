private Connection connection = null;

public void init(ServletConfig config) throws ServletException
{
    super.init(config);
    try 
    {
        // Load the MySQL driver
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(
        DB_URL, "root", "");
    }
    catch (ClassNotFoundException e)
    { 
        throw new UnavailableException(this, "Couldn't load database driver");
    }    
    catch (SQLException e) 
    { 
        throw new UnavailableException(this, "Couldn't get db connection");
    }    
}