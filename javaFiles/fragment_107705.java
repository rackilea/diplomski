private AtomicInteger a = new AtomicInteger(5);
public void setA(int a) {
   // no need to synchronize because of the magic of the `AtomicInteger` code
   this.a.set(a);
}
public int getA() {
    // AtomicInteger also takes care of the memory synchronization
    return a.get();
}