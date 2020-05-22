String contentLine = null;
   BufferedReader reader = new BufferedReader(
                                    new FileReader(getfileRootDir()+ "/"+fileId));

   URL oracle = new URL("other server url");
   HttpURLConnection connection = (HttpURLConnection)url.openConnection();
   OutputStream outPutStream = connection.getOutputStrea()
   Writer streamWriter = new BufferedWriter(new OutputStreamWriter(outPutStream ));
   while ((contentLine = reader.readLine()) != null) {
        streamWriter.write(contentLine );
   }
   reader.close();       
   streamWriter.close();
   outPutStream .close(); 
   connection.close();