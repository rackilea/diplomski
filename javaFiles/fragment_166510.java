public class MyRunnable implements Runnable {
     protected Integer mFoo;

     public MyRunnable(Integer foo) { 
        mFoo = foo;
     }

     @Override
     public void run() {
          // access mFoo when you need it
           ...
     }
}