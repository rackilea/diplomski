public static String getFileContent(
   FileInputStream fis,
   String          encoding ) throws IOException
 {
   try( BufferedReader br =
           new BufferedReader( new InputStreamReader(fis, encoding )))
   {
      StringBuilder sb = new StringBuilder();
      String line;
      while(( line = br.readLine()) != null ) {
         sb.append( line );
         sb.append( '\n' );
      }
      return sb.toString();
   }
}