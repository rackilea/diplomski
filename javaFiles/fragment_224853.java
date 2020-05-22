public class Main {
public static void main(String[] args) {
    MyThread1 th1 = new MyThread1();
    MyThread2 th2 = new MyThread2();
    //Allow thread 1 to run first
    Shareable shareable = new Shareable();
    shareable.threadToRun = th1.getName();
    th1.setAnotherThread(th2);
    th1.setShareable(shareable);
    th2.setAnotherThread(th1);
    th2.setShareable(shareable);
    th1.start();
    th2.start();
}
}
class Shareable {
    volatile String threadToRun;
}
class MyThread1 extends Thread {

private Shareable shareable;
private Thread anotherThread;

@Override
public void run() {
    synchronized (shareable) {
        waitForTurn();
        System.out.println(getName() +  " I am doing first task. After that wait for next Thread to finish.");
        shareable.threadToRun = anotherThread.getName();
        shareable.notifyAll();
        waitForTurn();
        System.out.println(getName() +  " I am doing next task now.");
    }
}

private void waitForTurn(){
    if(!shareable.threadToRun.equals(getName())){
        try {
            shareable.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public void setShareable(Shareable shareable){
    this.shareable = shareable;
}
public void setAnotherThread(Thread anotherThread){
    this.anotherThread = anotherThread;
}


}
class MyThread2 extends Thread {

private Shareable shareable;
private Thread anotherThread;

@Override
public void run() {
    synchronized (shareable) {
        waitForTurn();
        System.out.println(getName() +  " I am doing task now. Another Thread " + anotherThread.getName() + " is in state " + anotherThread.getState());
        shareable.threadToRun = anotherThread.getName();
        shareable.notifyAll();
    }
}

private void waitForTurn(){
    if(!shareable.threadToRun.equals(getName())){
        try {
            shareable.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public void setShareable(Shareable shareable){
    this.shareable = shareable;
}
public void setAnotherThread(Thread anotherThread){
    this.anotherThread = anotherThread;
}
}