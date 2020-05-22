try{
    con = (Connection) DriverManager.getConnection(url, user, password);
    ...
}catch (SQLException ex) {
    Logger lgr = Logger.getLogger(Version.class.getName());
    lgr.log(Level.SEVERE, ex.getMessage(), ex);
} catch (java.sql.SQLException e) {
    e.printStackTrace();
}