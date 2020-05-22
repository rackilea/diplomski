private static final DataSource dataSource;

static
{
    DataSource tempDataSource = null;
    try
    {                
        Context initContext = new InitialContext();
        Context context = (Context) initContext.lookup("java:comp/env");
        tempDataSource = (DataSource) context.lookup("jdbc/assignment_db");
    } catch (NamingException ex) {
        Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
    dataSource = tempDataSource;
}