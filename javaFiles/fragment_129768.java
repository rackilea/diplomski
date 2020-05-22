public class NewServerPool extends Thread {

    private final int NTHREADS = 10;
    private ExecutorService executor;
    private Vector<Future<String>> futures;

    public NewServerPool(int port, SearchQuery typeOfQuery) {
        executor = Executors.newFixedThreadPool(NTHREADS);
        futures = new Vector<Future<String>>();
    }

    public void run() {
        while(true){
            SearchQuery client = null;

            if (typeOfQuery == 1) {
                client = new SocketQuery(....);
            } else if (typeOfQuery == 2) {
                client = new StringQuery(...);
            }
            futures.add(executor.submit(new NewSearchThread(client)));
        }
    }
}