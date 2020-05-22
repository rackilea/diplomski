public class ThreadTesterRunner {
    public static void main(String[] args) throws InterruptedException {
        final Phaser cb = new Phaser();
        ThreadRunner tr = new ThreadRunner(cb);
        Thread t = new Thread(tr, "Thread Runner");
        t.start();

        boolean process = true;
        // wait until all threads process, then print reports
        while (process){
            if(tr.getIsFinished()){
                System.out.println("Print metrics");
                process = false;
            }
            //else {
            //  System.out.println("Waiting:  registered=" + cb.getRegisteredParties() + ", arrived=" + cb.getArrivedParties() + ", unarrived=" + cb.getUnarrivedParties());
            //}
            Thread.sleep(1000);
        }
    }
}


class ThreadRunner implements Runnable {
    static int timeOutTime = 2;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final Phaser barrier;
    private boolean isFinished=false;

    public ThreadRunner(Phaser phaser) {
        this.barrier = phaser;
    }

    public void run(){
        try {
            boolean stillLoop = true; int i = 0;
            while (stillLoop){
                int size;
                Future<Integer> future = null;
                try {
                    future = executorService.submit(new Reader(this.barrier)); // sleeps
                    size = future.get();
                } catch (InterruptedException | ExecutionException ex) {
                    // handle Errs
                }

                if(i == 3){
                    stillLoop = false;
                    this.barrier.awaitAdvance(0);
                    this.isFinished=true;
                }
                //System.out.println("i = "+i+"  Size is: "+size+"\r");
                i++;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public boolean getIsFinished(){
        return this.isFinished;
    }
}

class Reader implements Callable {
    private Phaser barrier;
    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    public Reader(Phaser phase) {
        phase.register();
        this.barrier = phase;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("Reading...");
        Thread.sleep(2000);
        executorService.submit(new Writer(this.barrier));
        this.barrier.arrive();
        return 1000;
    }
}

class Writer implements Callable {
    private Phaser barrier;

    public Writer(Phaser phase) {
        phase.register();
        this.barrier = phase;
    }

    @Override
    public Void call() throws Exception {
        Thread.sleep(4000);
        System.out.println("Wrote");
        this.barrier.arrive();
        return null;
    }
}