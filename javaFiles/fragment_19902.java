public class Listener implements Runnable {

    private ServerSocket serverSocket;
    ExecutorService executorService = Executors.newCachedThreadPool();

    public Listener(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket accept = serverSocket.accept();
                executorService.execute(new Worker(accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}