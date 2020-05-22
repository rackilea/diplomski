ExcelUtils objExcelutils; //Object of your 2nd class

    public class Test{


    //all the code from your first class


      objExcelutils.writeUniqueID(uniqueID);

    }

    // this is your 2nd class
    int rowCount=1;   //variable for the row count
    public class Excelutils
    {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet worksheet = workbook.createSheet("IncidentNo");
       public void writeUniqueID(String uniqueID)
       {
           HSSFRow row = worksheet.createRow(rowCount);
           HSSFCell cell = row.createCell(rowCount);
           cell.setCellValue(uniqueID);
           rowCount++;
       }

    }
    try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx"))        {
            workbook.write(outputStream);
        }

}