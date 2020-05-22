public void getUsersName() throws SQLException {
    java.sql.Connection con = DriverManager.getConnection(url + dbName, userName, password);
    JList<String> list = new JList<>();
    PreparedStatement ps = con.prepareStatement("SELECT Username FROM tblcustomers ORDER BY UserID");
    ResultSet result = ps.executeQuery();

    DefaultListModel<String> listModel = new DefaultListModel<>();
    if (result != null) {
        while (result.next())

        {
            ListUserNames.listModel.addElement(result.getString("Username"));
        }

    }

    ps.close();
    con.close();
}