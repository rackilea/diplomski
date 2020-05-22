private static boolean condition = false;// you can you semaphore too class level variable
public void methodA(){
      synchronized(LOCK){
           if(condition){ return;}// returning if already executed
           ..some code
           // Set condition to true so then again it should not run
           condition = true;
      }
}