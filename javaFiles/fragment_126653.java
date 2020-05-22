private static final Object A = new Object();
private static final Object B = new Object();

public static void methodA() {
    synchronized (A) {
            //Do Job
    }
}

public static void methodB() {
    synchronized (B) {
            //Do Job
    }
}

public static void methodSync() {
    synchronized (A) {
      synchronized (B) {
            //Do Job
      }
    }
}