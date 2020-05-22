public void run() {
   while (true) {
     a.aMethod(b);
   }
}
...
public void run() {
   while (true) {
     b.bMethod(a);
   }
}
...
public synchronized void aMethod(B b) {
    System.out.println("B method");
    b.bMethod(this);
}
...
public synchronized void aMethod(A a) {
    System.out.println("A method");
    a.aMethod(this);
}