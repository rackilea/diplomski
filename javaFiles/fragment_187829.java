class Test implements Runnable 
{
     public void run() {
      // ... thread's task, when it is started using .start()
      }

     // Overloaded method  : Needs to be called explicitly.
     public void run(char a) { 
      //do  something with char a ;  
     }
}