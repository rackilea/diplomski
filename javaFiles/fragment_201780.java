public static void main(String[] args){
     Thread.currentThread().setPriority(7); // currently executing thread is Main thread and its priority is set as 7 from its default value of 5
     Thread t = new MyThread(); // its priority is set to 7 as current executing thread has priority equal to 7.

    t.setPriority(3); // priority of Thread object referenced by t is set to 3.

   Thread.currentThread().setPriority(8); // main thread is currently executing thread hence its priority is set as 8.

}

public class MyThread extends Thread {

     public Thread(){
          Thread.currentathread().setPriority(9); // Main thread is currently executing thread hence its priority is set as 9.
          this.setPriority(8); // this refers to object of MyThread , the current object hence its priority is set as 8 not of main.
     }
     public void run(){
         Thread.currentThread().setPriority(2); // currently executing thread is MyThread`s object hence its priority is set as 2.
         this.setPriority(4); // again currently executing thread is Object of MyThread hence its priority is set as 4.
     }
}