public Object[][] getTableData (JTable table) {
       (DefaultTableModel) dtm = (DefaultTableModel) table.getModel();
           int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
           Object[][] tableData = new Object[nRow][nCol];
           for (int i = 0 ; i < nRow ; i++)
               for (int j = 0 ; j < nCol ; j++)
                   tableData[i][j] = dtm.getValueAt(i,j);
           return tableData;
       }