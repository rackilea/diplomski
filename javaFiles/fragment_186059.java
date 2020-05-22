public static Connection getJdbcConnection(
              JdbcConnectionParameters jdbcConnectionParameters)
                                     throws JdbcConnectionFailureException {
    try {
        if (jdbcConnectionParameters.driverNeedsHelpRegisteringUsingClassForName()) {
            Class.forName(jdbcConnectionParameters
                                .getClassForNameDriverRegistrationString());
        }
        return DriverManager.getConnection(jdbcConnectionParameters
                   .getJbdcConnectionUrl());
        // TODO: perform further validation on the connection
    } 
    catch (ClassNotFoundException classNotFoundException) {
        throw new JdbcConnectionManager.JdbcConnectionFailureException(
            classNotFoundException);
    } 
    catch (SQLException sqlException) {
        throw new JdbcConnectionManager.JdbcConnectionFailureException(
            sqlException);
    }
}