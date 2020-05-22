private static void accessReadOnlyJar() {
    try {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        Properties props = new Properties();
        String tempDir = System.getProperty("java.io.tmpdir");
        props.setProperty("derby.storage.tempDirectory", tempDir);
        props.setProperty("derby.stream.error.file", tempDir+"derby_error.log");
        Connection connection = DriverManager.getConnection("jdbc:derby:jar:(data/db.jar)derbyDB", props);

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM TESTTABLE");
        while(result.next()){
            System.out.println(result.getString("NAME"));
        }

        connection.close();
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}