private Object[] timeZoneArgs = new Object[] { "Europe/Berlin" };

@Override
public Connection getConnection() throws SQLException {
    Connection conn = super.getConnection();
    try {
        final Method setSessionTimeZoneMethod = OracleConnection.class.getMethod("setSessionTimeZone", String.class);
        final C3P0ProxyConnection castCon = (C3P0ProxyConnection) conn;
        castCon.rawConnectionOperation(setSessionTimeZoneMethod, C3P0ProxyConnection.RAW_CONNECTION, timeZoneArgs);
        return conn;
    } catch (Exception e) {
        log.error("setSessionTimeZone failed " + e.getMessage());
        return conn;
    }
}