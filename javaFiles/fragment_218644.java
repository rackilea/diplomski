InputStream is = null;
try {
   is = new FileInputStream(..);
   // do something with stream
} finally {
   try {
      is.close();
   } catch (Exception ex){ 
      //report problem
   }
}