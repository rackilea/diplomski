// import org.apache.poi.ss.usermodel.*;

DataFormatter formatter = new DataFormatter();
Sheet sheet1 = wb.getSheetAt(0);

//TODO int numberOfRows=getNumberOf Rows from sheet1;
//TODO USCrimeClass[] arrayOfUSCrimeClass =new USCrimeClass [numberOfRows](); 

for (Row row : sheet1) {

     //TODO create new object of USCrimeClass
     //TODO USCrimeClass objectUSCrimeClass=new USCrimeClass();
    for (Cell cell : row) {
        CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
        System.out.print(cellRef.formatAsString());
        System.out.print(" - ");

        // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
        String text = formatter.formatCellValue(cell);
        System.out.println(text);

        // Alternatively, get the value and format it yourself
        switch (cell.getCellTypeEnum()) {
            case CellType.STRING:
                System.out.println(cell.getRichStringCellValue().getString());
                //TODO set values to feild from excel cell objectUSCrimeClass.setFrom(cell.getRichStringCellValue().getString());
                break;
            case CellType.NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.println(cell.getDateCellValue());
                } else {
                    System.out.println(cell.getNumericCellValue());
                }
                break;
            case CellType.BOOLEAN:
                System.out.println(cell.getBooleanCellValue());
                break;
            case CellType.FORMULA:
                System.out.println(cell.getCellFormula());
                break;
            case CellType.BLANK:
                System.out.println();
                break;
            default:
                System.out.println();
        }
    }

//TODO add row object to array or list  arrayOfUSCrimeClass[i]=objectUSCrimeClass;
}