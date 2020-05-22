public void dbConnection() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youngrob_database", "youngrob_user", "password");
        st = con.createStatement();
        Logger.getLogger(DbUtil.class.getName()).log(Level.INFO, "Db Connected..........");
    } catch (Exception ex) {
        Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        // st = '';
        // con = '';
        // throw new SQLException("Failed to get DB Connection");

        // if you can not throw checked exception then          
        throw new RuntimeException("Failed to get DB Connection");          
    }
}