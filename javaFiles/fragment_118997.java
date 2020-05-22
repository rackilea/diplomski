public boolean canConnect() {
    try {
        con = DriverManager.getConnection(url, login, password);
        //executed only if no errors are thrown
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        //can't connect
        return false;
    } finally {
        //close connection if it was successful
        try {
            if (con!=null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}