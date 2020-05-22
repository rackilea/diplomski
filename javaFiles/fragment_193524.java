response.setContentType("application/msword");
 response.setHeader("Content-Disposition","attachment;filename=downloadname.doc");
 File file=new File("d:\\test.doc");
 InputStream is=new FileInputStream(file);
 int read=0;
 byte[] bytes = new byte[BYTES_DOWNLOAD];
 OutputStream os = response.getOutputStream();
 while((read = is.read(bytes))!= -1){
  os.write(bytes, 0, read);
 }
 os.flush();
 os.close();