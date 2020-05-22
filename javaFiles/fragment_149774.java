static
{
    try
    {                
        Context initContext = new InitialContext();
        Context context = (Context) initContext.lookup("java:comp/env");
        dataSource = (DataSource) context.lookup("jdbc/assignment_db");
    } catch (NamingException ex) {
        Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        throw new ExceptionInInitializerError("dataSource not initialized");
    }
}