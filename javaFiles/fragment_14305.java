private final static Object lock = new Object();
 private static int common = 0;
 ...

 synchronized (lock) {
     common++;
 }