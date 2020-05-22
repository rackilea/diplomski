public void columnSelectionChanged(ListSelectionEvent e) {
    //assuming single column is selected
    Object[] data = columnToArray(table,table.getSelectedColumn());
   /* type cast if using specific data type. for eg:
    * Integer[] data = (Integer[]) columnToArray(table,table.getSelectedColumn());
    */
    // other functions to create the summary
}