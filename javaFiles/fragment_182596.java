import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRun implements Runnable{
    AtomicInteger global = new AtomicInteger(0);
    //create sets
    static Vector t1v = new Vector();
    static Vector t2v = new Vector();
    static Vector t3v = new Vector();           
    public void run() {
        action1();
    }
    public void action1() {
        for(int i = 0; i < 1000; i++) {
            global.incrementAndGet();
            int x = global.get();
            String tName = Thread.currentThread().getName();
            if(tName == "t1") {
                t1v.addElement(x);
            }
            if(tName == "t2") {
                t2v.addElement(x);
            }
            if(tName == "t3") {
                t3v.addElement(x);
            }           
            //System.out.println("thread: " + tName  + "counter is: " + global);
        }   
        }
    public static Vector gett1v() {
        return t1v;
    }

    public static Vector gett2v() {
        return t2v;
    }

    public static Vector gett3v() {
        return t3v;
    }

}

class ThreadTest{

    public static void main(String[] args) {
        //create threads
        Runnable threadJob = new MyRun();
        Thread t1 = new Thread(threadJob);
        t1.setName("t1");
        Thread t2 = new Thread(threadJob);
        t2.setName("t2");
        Thread t3 = new Thread(threadJob);
        t3.setName("t3");


        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();

        }catch(InterruptedException e){}
        Vector th1v = MyRun.gett1v();
        Vector th2v = MyRun.gett2v();
        Vector th3v = MyRun.gett3v();
        //MyRun.printSets();
        System.out.println(th1v.size()+" "+th2v.size()+" "+th3v.size());
        for(int i=0; i < th1v.size(); i++) {
            System.out.println("Thread 1: " + th1v.elementAt(i));
        }

        for(int i=0; i < th2v.size(); i++) {
            System.out.println("Thread 2: " + th2v.elementAt(i));
        }


        for(int i=0; i < th3v.size(); i++) {
            System.out.println("Thread 3: " + th3v.elementAt(i));   
    }
    }
}