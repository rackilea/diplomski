public class ServerSocketWorker extends SwingWorker<Void, String> {

    private JTextArea ta;

    public ServerSocketWorker(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String text : chunks) {
            ta.append(text);
        }
    }

    @Override
    protected Void doInBackground() throws Exception {
        ss = new ServerSocket(1234, 3);
        while (true) {
            publish("\nEsperando conexiones...");
            Socket s = ss.accept();
            publish("\nConexión entrante: " + s.getRemoteSocketAddress());

            conexiones++;
            //System.out.println("Debug: conexiones SERVER: " + conexiones);
            MultiThread mt = new MultiThread(s, conexiones);
            mt.start();
            ///////////////////////////////////////////////////////////////
        }
    }

    @Override
    protected void done() {
        stopServer(); //??
    }
}