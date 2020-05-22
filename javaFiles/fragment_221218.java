private Connection con;

protected void close() throws SQLException {
    if (con != null) {
        con.close();
    }
}

protected Connection getConnection() throws ClassNotFoundException, SQLException {
    if (con == null) {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String url = "jdbc:odbc:*****";
        String user = "******";
        String pass = "******";
        Connection con = DriverManager.getConnection(url, user, pass);
    }
    return con;
}

private void search() throws Exception {

    Statement state = null;
    ResultSet rs = null;

    try {

        state = getConnection().createStatement();

        rs = state.executeQuery("SELECT "
                + "pIDNo AS 'Patient ID',"
                + "pLName AS 'Last Name',"
                + "pFName AS 'First Name',"
                + "pMI AS 'M.I.',"
                + "pSex AS 'Sex',"
                + "pStatus AS 'Status',"
                + "pTelNo AS 'Contact No.',"
                + "pDocID AS 'Doctor ID',"
                + "pAddr AS 'St. No.',"
                + "pStreet AS 'St. Name',"
                + "pBarangay AS 'Barangay',"
                + "pCity AS 'City',"
                + " pProvince AS 'Province',"
                + " pLNameKIN AS 'Last Name',"
                + "pFNameKIN AS 'First Name',"
                + "pMIKIN AS 'M.I.',"
                + "pRelationKIN AS 'Relation',"
                + "pTotalDue AS 'Total Due'"
                + " FROM dbo.Patients");
        ResultSetMetaData rsmetadata = rs.getMetaData();
        int columns = rsmetadata.getColumnCount();

        DefaultTableModel dtm = new DefaultTableModel();
        Vector column_name = new Vector();
        Vector data_rows = new Vector();

        for (int i = 1; i < columns; i++) {
            column_name.addElement(rsmetadata.getColumnName(i));
        }
        dtm.setColumnIdentifiers(column_name);

        while (rs.next()) {
            data_rows = new Vector();
            for (int j = 1; j < columns; j++) {
                data_rows.addElement(rs.getString(j));
            }
            dtm.addRow(data_rows);
        }
        tblPatient.setModel(dtm);

    } finally {
        try {
            rs.close();
        } catch (Exception e) {
        }
        try {
            state.close();
        } catch (Exception e) {
        }
    }
}