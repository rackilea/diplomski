class Process{
     public void increment() { 
           synchronized(this){
                  counter++; 
            }
}