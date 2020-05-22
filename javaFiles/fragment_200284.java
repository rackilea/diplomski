String dbPath = "src/home/accounting/DB/myDatabase.sqlite";
File dbFile = new File(dbPath);
if (dbFile.exists()) {
    //database already exist don't create it again
} else {
    Connection c = null;
    try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        System.out.println("Opened database successfully");
        return c;
    } catch (ClassNotFoundException | SQLException e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        return null;
    }
}