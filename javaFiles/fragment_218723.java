public Connection getConnection(DBType dbType) throws SQLException {

        return DriverManager.getConnection(dbType.getUrl(),
                    dbType.getUsername(), dbType.getPasword());

}