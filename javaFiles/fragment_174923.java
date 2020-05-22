pool = Executors.newScheduledThreadPool(numberOfThreads, new TF());

class TF implements ThreadFactory {
    public synchronized Thread newThread(Runnable r) {
        Thread t = new Thread(r) ;
        t.setName("Something here....");  
        return t;
    }
}