private Database getDatabase(IConnectionProfile profile) {
    IManagedConnection managedConnection = ((IConnectionProfile) profile)
            .getManagedConnection("org.eclipse.datatools.connectivity.sqm.core.connection.ConnectionInfo");
    if (managedConnection != null) {
        try {
            ConnectionInfo connectionInfo = (ConnectionInfo) managedConnection.getConnection().getRawConnection();
            if (connectionInfo != null) {
                Database database = connectionInfo.getSharedDatabase();
                return database;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    return null;
}