public SocketWorker implements Runnable {
    private final ThreadLocal<Socket> threadLocal;
    public SocketWorker(ThreadLocal<Socket> threadLocal) {
       this.threadLocal = threadLocal;
    }
    public void run() {
        Socket socket = threadLocal.get();
        // use the socket ...
    }
}