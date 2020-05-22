java.net.URLConnection conn = url.openConnection();  
java.io.InputStream is = conn.getInputStream();  
org.apache.poi.hssf.usermodel.HSSFWorkbook workBook = new org.apache.poi.hssf.usermodel.HSSFWorkbook( is );  
System.out.println( "Number of Sheets: " + workBook.getNumberOfSheets() );  
org.apache.poi.hssf.usermodel.HSSFSheet sheet = workBook.getSheetAt( 0 );  
System.out.println( "Sheet Name: " + sheet.getSheetName() );  

// rest of your code to handle the captured workBook
// cheers