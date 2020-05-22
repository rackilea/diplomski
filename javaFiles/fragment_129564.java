Set<String> values = new HashSet<String>();
for(WebElement e : list) {
    values.add(e.getText());
}  

for (int k = 1 ; k <= totalrows ; k++) {
    XSSFCell Cell = sheetname.getRow(k).getCell(0);
    Cell.setCellType(Cell.CELL_TYPE_STRING);
    String cellData = Cell.getStringCellValue();

    if (!values.contains(cellData)) {
        Log.info("Value Not found in Dropdown: " + cellData);
        Thread.sleep(1000);
    }
}