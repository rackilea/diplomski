private final Object lockA = new Object();
private final Object lockB = new Object();
public void methodA() {
    synchronized(lockA){
        ....
    }
}
public void methodB() {
    synchronized(lockB){
        ....
    }
}