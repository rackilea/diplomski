// this part is important to let the browser know what you're sending
response.setContentType("application/vnd.ms-excel");
// the next two lines make the report a downloadable file;
// leave this out if you want IE to show the file in the browser window
String fileName = "Blah_Report.xls";
response.setHeader("Content-Disposition", "attachment; filename=" + fileName); 

// get the workbook from wherever
HSSFWorkbook wb = getWorkbook();
OutputStream out = response.getOutputStream();
try {
   wb.write(out);
}       
catch (IOException ioe) { 
  // if this happens there is probably no way to report the error to the user
  if (!response.isCommited()) {
    response.setContentType("text/html");
    // show response text now
  }
}