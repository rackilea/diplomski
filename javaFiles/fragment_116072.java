public void closeStreams(Closeable c){
  try{
    c.close();
   }
   catch(IOException e){
   }

  finally{
  // well noting here now..
  }
}