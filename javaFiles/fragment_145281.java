new Thread("Batch Worker A"){
@Override 
public void run() {
    while(!stop){
            processBatch(Thread.currentThread().getName());
        }
    }
}}.start();