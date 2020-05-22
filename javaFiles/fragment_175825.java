private static AtomicReference<DBConnector> instance = new AtomicReference<>();

public static DBConnector getDBConnector(DBConfig dBConfig) {
    // First try
    DBConnector con = instance.get();
    if (con == null) {
        con = // ...

        if (instance.compareAndSet(null, con)) {
            // Successful swap, return our copy
            return con;
        } else {
            // Lost the race, poll again
            return instance.get():
        }
    }

    // Already present value
    return con;
}