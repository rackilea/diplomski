private void testSqli() throws SQLException, ClassNotFoundException {

    if (JavaFXPlatform.isAndroid()) {
        Class.forName("org.sqldroid.SQLDroidDriver");
    } else if (JavaFXPlatform.isIOS()) {
        Class.forName("SQLite.JDBCDriver");
    } else if (JavaFXPlatform.isDesktop()) {
        Class.forName("org.sqlite.JDBC");
    }

    File dir;
    String dbUrl = "jdbc:sqlite:";
    try {
        dir = PlatformFactory.getPlatform().getPrivateStorage();
        String dbName = "yourDatabase.db";
        File db = new File (dir, dbName);
        dbUrl = dbUrl + db.getAbsolutePath();
        Connection conn = DriverManager.getConnection(dbUrl);
        ...
    } catch (IOException ex) { }
}