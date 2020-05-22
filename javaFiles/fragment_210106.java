public synchronized void add(Object boar) {
    /** If there's no free space available wait **/
    while (!hasFreeSpace()) {
     try{
         wait();
     }catch(InterruptedException e){ 
        Thread.currentThread().interrupt(); 
        return; //or rethrow
     }
    }
    /** Once there's free space available add new item **/
    boars.add(boar);
}