String threadName;
Thread thread;
public ThreadExample() {
    thread=new Thread(this);
}

public void startThread() {
   thread.start();
}