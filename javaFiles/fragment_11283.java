class ThreadedEchoHandler implements Runnable {
    final private Socket incoming;
    private String nomeAccount = "";

    ThreadedEchoHandler(ServerSocket serv) throws IOException {
        incoming = serv.accept();
        new Thread(this).start();
    }

    public void run() {
        // do stuff
    }
}