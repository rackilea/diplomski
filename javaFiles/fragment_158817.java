// int columnFlag=0; //too early here
while (rowFlag != rowCount) {
     Row row = sheet.createRow(rowFlag);

     int columnFlag=0; //here it belongs - reset columns for every row

     Iterator<WebInOutTrx> it = givenList.iterator();
     while (columnFlag != columnCount) {
        String fieldName = dataTmpltList.get(columnFlag).getFieldName();