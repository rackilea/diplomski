//
// Create an instance of workbook and sheet
//
HSSFWorkbook workbook = new HSSFWorkbook();
HSSFSheet sheet = workbook.createSheet();
sheet.setAutobreaks(true);
 .
 .//code in which you create actual rows and cells HERE  
 .
//auto formating to fit the page
for(int i=0; i<repModel.getReportHeaders().length;i++){
sheet.autoSizeColumn((short) (i+1));     
}