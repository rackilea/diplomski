int counter = 0;
for (int i = 0; i <myTable.getRowCount(); i++) {
    myTable.selectCell(i, 1);
    if (myTable.getIcon(i, 0) == ("blue.gif")) {
        if (myTable.getRowValue(i, 0).contains("ble.")) {
           counter++;
           System.out.println(counter);
        }
    }
}