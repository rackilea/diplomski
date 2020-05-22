public class MyThread implements Runnable, Comparable<MyThread> {

    private static volatile int idCount;

    private volatile int id;
    private volatile boolean running;

    public MyThread() {
        id = idCount++;
    }

    @Override
    public void run() {

        running = true;

        while ( running ) {
            System.out.printf( "Thread %d is running!\n", id );
            try {
                Thread.sleep( 1000 );
            } catch ( InterruptedException exc ) {
                exc.printStackTrace();
            }
        }
    }

    public void stop() {
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo( MyThread o ) {
        return this.id - o.id;
    }
}

public class TestMyThread {

    public static void main( String[] args ) {

        Scanner scan = new Scanner( System.in );
        ExecutorService es = Executors.newCachedThreadPool();
        Map<Integer, MyThread> myThreads = new ConcurrentSkipListMap<>();

        int opt = 0;
        int threadToRemoveId = 0;

        while ( opt != 3 ) {

            System.out.println( "1 - Create and start a thread." );
            System.out.println( "2 - Stops a thread." );
            System.out.println( "3 - Finish all threads." );
            System.out.println( "Choose an option: " );
            opt = scan.nextInt();

            switch ( opt ) {

                case 1:

                    MyThread newThread = new MyThread();
                    myThreads.put( newThread.getId(), newThread );
                    es.execute( newThread );

                    break;

                case 2:

                    System.out.println( "What thread should be removed? " );
                    threadToRemoveId = scan.nextInt();

                    MyThread threadToRemove = myThreads.remove( threadToRemoveId );
                    if ( threadToRemove != null ) {
                        threadToRemove.stop();
                    }

                    break;

                case 3:
                    myThreads.forEach(( Integer t, MyThread u ) -> {
                        u.stop();
                    });
                    es.shutdown();
                    break;

                default:
                    System.err.println( "Wrong option!" );
                    break;
            }


        }

    }

}