private final int[] a;
 private final int[] b;

 Ctor(int n) {
    a = new int[n];
    b = new int[n];
 }

 public final methodA() {
    synchronized(a) {
       ...
    }
 }

 public final methodB() {
    synchronized(b) {
       ...
    }
 }