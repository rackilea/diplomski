private static final Object lock = new Object();

 void yourMethod() {
     synchronized (lock) {
         // your code here
     }
 }