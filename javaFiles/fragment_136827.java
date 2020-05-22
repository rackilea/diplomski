String data;

if(cell.getCellType()==CellType.STRING) 
    data = cell.getStringCellValue(); 
else if(cell.getCellType()==CellType.NUMERIC) 
    data = String.valueOf(cell.getNumericCellValue());
else ...