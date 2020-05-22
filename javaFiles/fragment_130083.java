Runtime rt = Runtime.getRuntime();
Process p = rt.exec(
  "C:/Program Files (x86)/wkhtmltopdf/wkhtmltopdf.exe --zoom 2 " 
    + temphtmlfile.getAbsolutePath()
    + " " 
    + filePdf.getAbsolutePath()) ;