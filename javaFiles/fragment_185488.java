public static void main(String[] args) throws IOException{
    String excelFilePath = "C:\\Users\\gotpist1\\Desktop\\SRBNOI.xlsx";
    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
    XSSFSheet firstSheet = workbook.getSheetAt(0);
    int rowCnt = firstSheet.getLastRowNum();
    try{
        for(int i = 1; i <= rowCnt; i++){
            if(i == 3)
                break;
            XSSFRow r = firstSheet.getRow(i);
            int res = i;
            Cell cell = null;
            if(cell == null){
                cell = r.createCell(5);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue("f" + res);
            }
        }
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\gotpist1\\Desktop\\SRBNOI.xlsx"));
        workbook.write(out);
        out.close();
        inputStream.close();
        System.out.println("done");
    }

}