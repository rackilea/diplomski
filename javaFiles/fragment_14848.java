int contentChar = null;
 FileInputStream inputStream = new FileInputStream(getfileRootDir()+ "/"+fileId));

 URL oracle = new URL("other server url");
 HttpURLConnection connection = (HttpURLConnection)url.openConnection();
 OutputStream outPutStream = connection.getOutputStrea()
 while ((contentChar = inputStream.read()) != -1) {
      outPutStream.write(contentLine );
 }
 inputStream .close();
 outPutStream.close(); 
 connection.close();