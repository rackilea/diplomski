public void closeStream(Closeable s){
    try{
        if(s!=null)s.close();
    }catch(IOException e){
        //Log or rethrow as unchecked (like RuntimException) ;)
    }
}