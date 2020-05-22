ResourceBundle props = ResourceBundle.getBundle("db");
OracleDataSource oracleDS = null;
try {
    oracleDS = new OracleDataSource();
    oracleDS.setURL(props.getString("url"));
    oracleDS.setUser(props.getString("user"));
    oracleDS.setPassword(props.getString("password"));
} catch (ResourceNotFoundException e) {
    e.printStackTrace();
} catch (SQLException e) {
    e.printStackTrace();
}
return oracleDS;