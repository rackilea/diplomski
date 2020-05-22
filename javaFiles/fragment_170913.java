public static void writeexcel(String Result,int RowNum ,int ColNum)
    {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");
        XSSFSheet ExcelWSheet = sheet;
        XSSFCell Cell;
        XSSFRow Row;

        try
            {


                Row  = ExcelWSheet.createRow(RowNum);

                Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);

                if (Cell == null) {

                    Cell = Row.createCell(ColNum);

                    Cell.setCellValue(Result);

                    } else {

                        Cell.setCellValue(Result);

                    }

                FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
                workbook.write(out);
                out.close();
                System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

    }