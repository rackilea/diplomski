String path = getServletContext().getRealPath("/") + "generatedApps/";     
  String fileName = appName + "Archive.zip";
  File f = new File(path + fileName);       

  response.setContentType("application/zip");     
  response.setContentLength((int)f.length());  
  response.addHeader("Content-Disposition","attachment;filename=\"" + fileName + "\"");    
  byte[] arBytes = new byte[32768];     
  FileInputStream is = new FileInputStream(f);
  ServletOutputStream op = response.getOutputStream();     
  int count;
  while ((count = is.read(arBytes)) > 0)
  {
      op.write(arBytes, 0, count);     
  }
  op.flush();