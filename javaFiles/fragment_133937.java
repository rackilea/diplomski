StringBuilder sb=new StringBuilder();
  BufferedReader br=null;

  try{
   br=new BufferedReader(new InputStreamReader(openFileInput(fileName));
   String line=null;
   while((line = br.readLine()) != null)
    {
      sb.append(line);
     }
   }catch(Exception ex){
     //
   }finally{
    if(br!=null)
      br.close();
   }
  return sb.toString();