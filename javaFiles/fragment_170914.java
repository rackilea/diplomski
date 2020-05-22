public class Tests {

    static XSSFWorkbook workbook = new XSSFWorkbook();

    static  XSSFSheet sheet = workbook.createSheet("Employee Data");

    public static void main(String[] args) {

        int j=3;

    for(int i=2;i<=5;i++) { 

        String result = "Test "+i;

        writeexcel(result, i, j);

    }
    writetoexcel();//write to cell(2,3),(3,3),(4,3)
    }

    public static void writeexcel(String Result,int RowNum ,int ColNum)
    {

        //Create a blank sheet

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

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
    }

    public static void writetoexcel(){

        try{
            FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
            }catch (Exception e)
            {
                e.printStackTrace();
            }

    }
    }