...
POM obj = new POM();
String cellValue = poi.getDataFromExcel("column name", row_number);
if (cellValue != null && !cellValue.isEmpty()) {
    obj.method1(cellValue);
}
...