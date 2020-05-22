class MyThread extends Thread {
     public void run() {
         throw new RuntimeException();
     }
 }

...

new MyThread().start();
// here thread dies silently with no visible effects at all