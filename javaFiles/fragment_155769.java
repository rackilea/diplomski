public TableModel populateTable(int qryType) throws SQLException{ 
    DefaultTableModel tblModel = new DefaultTableModel(){
       @Override
       public boolean isCellEditable(int row, int column){
          return false;
       }
    };
    String qry = "SELECT * FROM Services";
    try (Connection dbconn = SQL.dbConn(); 
        Statement stmt = dbconn.createStatement();
        ResultSet rs = stmt.executeQuery(qry)) {

        int numCols = rs.getMetaData().getColumnCount();            
        for (int col = 1; col <= numCols; col++){
            tblModel.addColumn(rs.getMetaData().getColumnLabel(col));
        }

        int row = 0;
        while (rs != null && rs.next()){
            tblModel.addRow(new Object[0]);
            tblModel.setValueAt(rs.getString("ServiceID"), row, 0);
            tblModel.setValueAt(rs.getString("Institution"), row, 1);
            tblModel.setValueAt(rs.getString("Comments"), row, 2);
            row++;
        }   
    }
    return model;
}