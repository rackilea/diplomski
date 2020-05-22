ComboPooledDataSource ds = new ComboPooledDataSource();

// testing with various pool sizes - same effect
ds.setMinPoolSize(1);
ds.setMaxPoolSize(5);
ds.setInitialPoolSize(2);

Thread connectingThread = new Thread() {

    public void run() {
        Connection cnxn = null;
        while (true) {
            try {
                cnxn = ds.getConnection();
                System.out.println("Got connection.);
                executeQuery(cnxn);
            } catch (SQLException e) {
                System.out.println("Got exception.");
                e.printStackTrace();

                // SOLUTION:
                Throwable cause = e.getCause();
                if (cause instanceof InterruptedException) {
                    System.out.println("Caught InterruptedException! Cnxn is " + cnxn);

                    // note that cnxn is a com.mchange.v2.c3p0.impl.NewProxyConnection
                    // also note that it's perfectly healthy.
                    //
                    // You may either want to:
                    // a) use the cnxn to submit your the query

                    executeQuery(cnxn);
                    cnxn.close()

                    // b) handle a proper shutdown

                    cnxn.close();

                }
                break;
            }
        }
    };
};

connectingThread.start();

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {          e.printStackTrace();        }

connectingThread.interrupt();