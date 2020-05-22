if (isPasswordCorrect(input)) {
    try {
        Connection conn = DriverManager.getConnection(
            "jdbc:h2:mem:", "sa", "secret");
        DatabaseMetaData metaData = conn.getMetaData();
        System.out.println("Version:"
            + " " + metaData.getDatabaseProductName()
            + " " + metaData.getDatabaseProductVersion()
            + " " + metaData.getDatabaseMajorVersion()
            + "." + metaData.getDatabaseMinorVersion());
    } catch (SQLException ex) {
        ex.printStackTrace(System.err);
    }
} ...