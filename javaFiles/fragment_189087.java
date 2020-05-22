public static String getStringFromInputStream(InputStream is)
        throws IOException {
   StringBuffer sb=new StringBuffer();
   BufferedReader reader=null;
   String line=null;
   try{
      reader=new BufferedReader(new InputStreamReader(is));
      while( (line=reader.readLine()) !=null){
           sb.append(line);
      }
   }catch(Exception ex){
       //
   }finally{
      if(reader!=null){
          try{
              reader.close();
          }catch(Exception ex) { }
      }
   }
  return sb.toString();
}