frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosed(WindowEvent e) {
        PrintStream nullStream = new PrintStream(new OutputStream() {
            public void write(int b) throws IOException {
            }

            public void write(byte b[]) throws IOException {
            }

            public void write(byte b[], int off, int len) throws IOException {
            }
        });
        System.setErr(nullStream);
        System.setOut(nullStream);
        System.exit(0);
    }
});