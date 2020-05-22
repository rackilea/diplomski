public static class SerialReader extends SwingWorker<Void, String> {   //Final frame = new Final();

    private InputStream in;
    private JLabel label;

    public SerialReader(InputStream in, JLabel label) {
        this.in = in;
        this.label = label;
    }

    @Override
    protected void process(List<String> chunks) {
        String data = chunks.get(chunks.size() - 1);
        label.setText(data);
    }

    @Override
    protected Void doInBackground() throws Exception {
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = this.in.read(buffer)) > -1) {
            String data = new String(buffer, 0, len);
            publish(data);
        }
        return null;
    }
}