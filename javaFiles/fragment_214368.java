if (isPasswordCorrect(input)) {
    try {
        EmbeddedDataSource ds = new EmbeddedDataSource();
        ds.setDatabaseName("/home/trashgod/.netbeans-derby/dbtest");
        Connection conn = ds.getConnection("sa", "secret");
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