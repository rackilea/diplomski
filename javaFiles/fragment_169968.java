Row row = sheet.getRow(i);
if (row != null) {
    for (int j = 0; j < row.getLastCellNum(); j++) {
        if (row.getCell(j) != null) {
            if (row.getCell(j).getCellType() == CELL_TYPE_STRING) {
                String value=row.getCell(j).getStringCellValue();
                if(value != null) { 
                    System.out.println(value);
                }
            }
        }   
    }
}