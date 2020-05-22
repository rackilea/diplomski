class SyncMethod implements Runnable {
Thread t;
ABC a;

SyncMethod(String s, ABC a) {
    this.a = a;
    t = new Thread(this, s);
    t.start();

}

public void run() {
    a.meth(t.getName());
}

public static void main(String args[]) {
    ABC a = new ABC();
    new SyncMethod("Hello", a);
    new SyncMethod("Synchronized", a);
    new SyncMethod("World", a);
}