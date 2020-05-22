/**
     * 
     * @param driverClassName
     * @param url
     * @param user
     * @param password
     * @throws SQLException 
     * @throws Exception 
     */
    public DefaultJdbcTransaction(String driverClassName, String url, String user, String password) throws SQLException {
        super();
        // TODO Auto-generated constructor stub
        try {
            Class.forName(driverClassName).newInstance();

            if (user == null && password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            throw new SQLException(e);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            throw new SQLException(e);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            throw new SQLException(e);
        }
    }