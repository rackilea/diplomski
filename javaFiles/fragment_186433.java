//initialize SQL connection
    try {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Cls_log.LogError(ex);
    }

private void ConnectSQL() {
    try {
        String url = "jdbc:jtds:sqlserver://<ip_address>/<db_name>;instance=<SQLserver_name>;loginTimeout=5;socketTimeout=2";
        SQLconnection = DriverManager.getConnection(url, <userName>, <password>);
        SQLSelectStatement = SQLconnection.createStatement();
    } catch (SQLException ex) {
        Cls_log.LogError(ex);
    }
}