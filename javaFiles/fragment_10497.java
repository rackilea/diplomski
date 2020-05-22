public static class InputStreamConsumer implements Runnable {

    private InputStream is;

    public InputStreamConsumer(InputStream is) {
        this.is = is;
    }

    public InputStream getInputStream() {
        return is;
    }

    public static void consume(InputStream is) {
        InputStreamConsumer consumer = new InputStreamConsumer(is);
        Thread t = new Thread(consumer);
        t.start();
    }

    @Override
    public void run() {
        InputStream is = getInputStream();
        int in = -1;
        try {
            while ((in = is.read()) != -1) {
                System.out.print((char)in);
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

}