class ThreadedEchoHandler implements Runnable {
    final private Socket incoming;
    private String nomeAccount = "";

    ThreadedEchoHandler(Socket incoming) {
        this.incoming = incoming;
    }

    public void run() {
        // do stuff
    }
}