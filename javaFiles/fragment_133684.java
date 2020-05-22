try {   
 URL url;
 url = new URL("http://YourWebSourceXML.xml");  


 InputStream in = url.openConnection().getInputStream();
 OutputStream out = new FileOutputStream("YourDestFile.xml");
 byte[] buffer = new byte[1024];
 for (int n;(n = in.read(buffer)) != -1;
         out.write(buffer, 0, n));

 in.close();
 out.close(); }
 catch (IOException e){
 // Do something
 }