for (int i = 0; i < table.nbColumns; i++) {
    MyCustomCellRenderer myRen = new MyCustomCellRenderer //now each column will use it's own renderer instance
    //also: don't forget to set myArg
    myRen.setArg(myArg);
    myJTable.getColumnModel().getColumn(i).setCellRenderer(myRen);
}