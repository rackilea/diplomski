private static final ExecutorService mThreadPool =
        Executors.newSingleThreadExecutor();

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mThreadPool.execute(new Runnable() {
        public void run() {
            // Do some work here...
        }
    });

    mThreadPool.execute(new Runnable() {
        public void run() {
            // Do some additional work here after
            // the first Runnable has finished...
        }
    });
}