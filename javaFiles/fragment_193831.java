public abstract class MyAbstractDao {
    private DataSource ds = null;

    protected DataSource getDataSource() {
        if (ds == null) {
            Context ctx = new InitialContext();
            Context envContext = (Context)ctx.lookup("java:comp/env");
            return (DataSource)envContext.lookup("jdbc/FooBar");    
        }
        return ds;
    }

    public void setDataSource(DataSource ds) {
        this.ds = ds;
    }
}