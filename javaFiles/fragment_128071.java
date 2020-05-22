OptionsListener(Options instance, int threadMillis) {
    optionsInstance = instance;
    this.threadMills = threadMillis;

    try {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        Statement stmt = conn.createStatement();
        stmt.execute("SET application_name = 'myapp'; LISTEN optionsupdate");
        stmt.close();
    } catch (SQLException e) {
        Log.addItem(getClass().getName() + " sql error:" + e.getMessage());
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e.getMessage(), e);
    }
}

@Override
public void run() {
    while (true) {
        try {
            PGNotification notifications[] = ((PGConnection) conn).getNotifications();
            if (notifications != null) {
                optionsInstance.loadDbData();
            }

            Thread.sleep(threadMills); 
        } catch (SQLException sqle) {
            Log.addItem(getClass().getName() + " sql error:" + sqle.getMessage());
        } catch (InterruptedException ie) {
            Log.addItem(getClass().getName() + " thread error: " + ie.getMessage());
        } 
    }
}