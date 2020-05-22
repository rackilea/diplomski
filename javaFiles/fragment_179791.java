Process p = Runtime.getRuntime().exec(cmd);
final InputStream is = p.getInputStream();
new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            while (is.available() != 0) {
                is.read();
            }
        } catch (IOException ex) {
        }
    }
}).start();