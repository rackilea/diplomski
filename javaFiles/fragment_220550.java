BufferedWriter bw = null;
try {
   bw = openWriter();
   doStuff();
} catch (IOException e) {
   handleError();
} finally {
   try {
       if (bw != null) bw.close();
   } catch (IOException e) { 
       // do nothing, or print stacktrace
   }
}