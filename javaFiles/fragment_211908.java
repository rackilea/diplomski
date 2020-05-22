private final Semaphore inB = new Semaphore(1);

public void a() throws InterruptedException {
    inB.acquire(); //blocks until no thread is in b any longer
    //now we are good to go and execute a()
    //release the semaphore immediately for other threads who want to run a()
    inB.release(); 
    //rest of your code here
}
public void b() {
    //does not block to allow 2 thread running b() simultaneously
    boolean needToRelease = inB.tryAcquire(); 
    //rest of your code
    //if the permit was acquired, release it to allow threads to run a()
    if (needToRelease) {
        inB.release();
    }
}