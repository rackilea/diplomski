class OutputHandler extends Thread {
    private final StringBuilder buf = new StringBuilder();
    private final BufferedReader in;

    OutputHandler(InputStream in, String encoding)
            throws UnsupportedEncodingException {
        this.in = new BufferedReader(new InputStreamReader(
                in, encoding == null ? "UTF-8" : encoding));
        setDaemon(true);
        start();
    }

    String getText() {
        synchronized(buf) {
            return buf.toString();
        }
    }

    @Override
    public void run() {
        // Reading process output
        try {
            String s = in.readLine();
            while (s != null) {
                synchronized(buf) {
                    buf.append(s);
                    buf.append('\n');
                }
                s = in.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}