@Override
    public Connection getConnection() throws SQLException {
        if ( !available ) {
            throw new HibernateException( "Provider is closed!" );
        }
        return useCredentials ? dataSource.getConnection( user, pass ) : dataSource.getConnection();
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }