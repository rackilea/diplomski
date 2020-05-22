class Process{
     public void increment() { 
           synchronized(Process.class){
                  counter++; 
            }
}