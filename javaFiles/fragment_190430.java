public void shutdown(){
    try{
        s.close();
    }catch(Exception e){
        e.printStacktrace();
    }
}