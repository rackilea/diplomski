protected Object doInBackground() throws Exception {
    ........
    resultDTO=//get data from database
    // This shouldn't be done here
    tableModel.setDataVector(resultDTO.getAllRows(), tableModel.getColumnNames());  
    // and neither should this
    // hide column
    table.removeColumn(table.getColumnModel().getColumn(7));