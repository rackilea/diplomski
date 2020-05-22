FileOutputStream output = null;
 InputStream is = blob.getBlob();
 try{
    output= new FileOutputStream(file);
    int b = 0;
    while ((b = is.read(buffer)) != -1) {
        output.write(buffer, 0, b);
    }          
} catch(IOException ex){
    System.err.println("Blob Error: "  + ex.getMessage());
} finally {
   is.close();
   if (output != null) {
       output.close();
   }

}