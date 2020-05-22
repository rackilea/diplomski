public class DAOManager {

    public static DAOManager getInstance() {
        return DAOManagerSingleton.INSTANCE;
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

    private DAOManager() throws Exception {
        try
        {
            InitialContext ctx = new InitialContext();
            this.src = (DataSource)ctx.lookup("jndi/MYSQL");
        }
        catch(Exception e) { throw e; }
    }

    private static class DAOManagerSingleton {

        public static final DAOManager INSTANCE;
        static
        {
            DAOManager dm;
            try
            {
                dm = new DAOManager();
            }
            catch(Exception e)
                dm = null;
            INSTANCE = dm;
        }        

    }

}