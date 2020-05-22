public static String[] array1 = {"devu","xyz","test","bb","run"};
public static String[] array2 = {"dvu","yz","tet","b","run"};
String excelFileName = "C:/Users/admin/IdeaProjects/Google_Demo/Write1.xlsx";//name of excel file

String sheetName = "Sheet1";//name of sheet

XSSFWorkbook wb = new XSSFWorkbook();
XSSFSheet sheet = wb.createSheet(sheetName);
//iterating r number of rows
for (int r = 0; r < 5; r++) {
    XSSFRow row = sheet.createRow(r);
    //iterating c number of columns
    for (int c = 0; c < 1; c++) {
            XSSFCell cell = row.createCell(c);
            cell.setCellValue(array1[r]);

    }
}
for (int r = 0; r < 5; r++) {
    XSSFRow row = sheet.getRow(r);
    // As per current input and code, this if block will never execute. 
    // However, adding it so that later, if first for loop will change, this code can work.
    if(row == null){
        row = sheet.createRow(r);        
    } 
    //iterating c number of columns
    for (int c = 2; c < 3; c++) {
        XSSFCell cell = row1.createCell(c);
        cell.setCellValue(array2[r]);
    }
}

FileOutputStream fileOut1 = new FileOutputStream(excelFileName);
//write this workbook to an Outputstream.
wb.write(fileOut1);
//fileOut.flush();
fileOut1.close();