public static void fetchDatafromDB(String startIndex, String finalIndex) {
    try {
        Class.forName(GlobalVariables.SQL_driver).newInstance();
        Connection conn = DriverManager.getConnection(GlobalVariables.DB_url + GlobalVariables.DB_name, GlobalVariables.DB_Username, GlobalVariables.DB_password);
        Statement st = conn.createStatement();
        String query = "SELECT  `FROM`, `To`, `IDno`, `TimeStamp` FROM `callsheet` WHERE TimeStamp BETWEEN '" + startIndex + "' AND '" + finalIndex + "'";
        ResultSet rs = st.executeQuery(query);
        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        TableItem item;
        while (rs.next()) {
            // Create a new TableItem for each entry in the result set (each row)
            item = new TableItem(table, SWT.NONE);
            for (int i = 1; i <= columnsNumber; i++) {
                // Populate the item (mind the index!!)
                item.setText(i - 1, rs.getString(i));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}