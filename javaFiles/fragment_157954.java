public static void main(String[] args) {

    try {
        FileInputStream is = new FileInputStream(new File("C:\\ook.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(is);
        HSSFSheet sheet = wb.getSheet("Sheet1");

        Row row =  sheet.getRow(0);
        Cell cell = row.getCell(0);

        System.out.println(cell.getNumericCellValue());//returns a double value so its ok

    } catch (IOException e) {
        e.printStackTrace();
    }
    finally{

    }
}