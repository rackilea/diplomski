public class hehe implements Runnable {
    static int count= 0;
    static Object lock = new Object();

    public void count(){
        synchronized(lock) {
            count++;
        }
    }

    public void run(){
        for (int i=0;i<10000;i++){
            count();
        }   
    }
}