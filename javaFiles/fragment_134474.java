package filevisitor;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

class child extends Thread{
    String name;
    volatile mother mom;
    public child(mother mom, String name){
        this.name = name;
        this.mom = mom;
    }

    public void run(){
        System.out.println(name+" is hungry.");
        while (!mom.finished){
            try {
                synchronized(work.myLockObject) {
                    work.myLockObject.wait();
                }
            }catch(InterruptedException e){}
        }
        washhands();
    }

    public void washhands(){
        System.out.println(name+" washed hands.");
        synchronized(work.myLockObject) {
            work.myLockObject.notifyAll();
        }
    }
}

class mother{
    boolean finished;

    public mother(){
        finished = false;
    }
    public void cook(){
        System.out.println("Mom started cooking.");
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){};
        finished = true;
        System.out.println("Mom finished cooking.");
        synchronized(work.myLockObject) {
            work.myLockObject.notifyAll();
        }
    }
}

public class work{
    public static final Object myLockObject = new Object();
    public static void main(String[] args){
        mother mom = new mother();
        child Alex = new child(mom, "Alex");
        child James = new child(mom, "James");
        child Tod = new child(mom, "Tod");

        Alex.start();
        James.start();
        Tod.start();
        mom.cook();
    }
}