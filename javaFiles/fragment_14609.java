private void cooldown(long ms) {
    try {
       this.sleep(ms);
    } catch (InterruptedException e) {
       Thread.currentThread.interrupt();
    }
}
public void foo() { 
    synchronized (this) {
       // foo's code
    }
    cooldown(1000);
}