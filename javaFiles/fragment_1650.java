public void run(){
  while (needsToRun){
    try{
    xSemaphore.P();
    System.out.println(getName());
    ySemaphore.V();
    }catch(InterruptedException E){
    System.out.println("Thread X was interrupted"); 
    }
  }
}