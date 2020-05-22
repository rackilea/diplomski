private static final Object LOCK = new Object(); 

public void methodA(){
    synchronized(LOCK){
     ..some code
   }
}