public class DAOManager {

    public DAOManager() throws Exception {
        try
        {
            InitialContext ctx = new InitialContext();
            this.src = (DataSource)ctx.lookup("jndi/MYSQL"); //The string should be the same name you're giving to your JNDI in Glassfish.
        }
        catch(Exception e) { throw e; }
    }

    public void open() throws SQLException {
        try
        {
            if(this.con==null || !this.con.isOpen())
                this.con = src.getConnection();
        }
        catch(SQLException e) { throw e; }
    }

    public void close() throws SQLException {
        try
        {
            if(this.con!=null && this.con.isOpen())
                this.con.close();
        }
        catch(SQLException e) { throw e; }
    }

    //Private
    private DataSource src;
    private Connection con;

}