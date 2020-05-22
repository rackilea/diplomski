/* The puppet class into the root project: */
public class DBManager implements DBManagerInterface {
    public DBManager() {
    }

    @Override
    public void executeQuery(String sql) {
    }
}


/* the desktop project: */
public class DBManager implements DBManagerInterface {
    public DBManager() {
    }

    @Override
    public void executeQuery(String sql) {
        /* insert here the code to execute a query 
           locally on the desktop application */
    }
}

/* the WebGL project: */
public class DBManager implements DBManagerInterface {
    public DBManager() {
    }

    @Override
    public void executeQuery(String sql) {
        /* insert here the code to execute a query 
           using a client-server interaction via GWT RPC */
    }
}