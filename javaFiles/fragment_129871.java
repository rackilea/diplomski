public boolean connectToAccess(String accessFilePath) {
    //Get connection to database
    try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        myConnection = DriverManager.getConnection("jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + accessFilePath);
    } catch (Exception ex) {
        ex.printStackTrace();
        return false;
    }
    return true;
}