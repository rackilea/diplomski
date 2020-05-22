public static void main(String[] args) {
    final int SIZE = 1024*1024; //1 MiB

    //simulates downloading a 1 MiB file
    final InputStream in = new InputStream() {
        int read = 0;
        public int read() throws IOException {
            if ( read == SIZE ) {
                return -1;
            } else {
                if ( read % 200 == 0 ) {
                    try { Thread.sleep(1); } catch ( InterruptedException e ) {}
                }
                read++;
                return 5;
            }
        }
    };

    final JProgressBar progress = new JProgressBar(0, SIZE);

    final JButton button = new JButton("Start");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            button.setText("Working...");
            SwingWorker<byte[], Integer> worker = new SwingWorker<byte[], Integer>() {
                @Override
                protected byte[] doInBackground() throws Exception {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    for ( int read = -1; (read = in.read(buff)) != -1; ) {
                        baos.write(buff, 0, read);
                        publish(read);
                    }
                    return baos.toByteArray();
                }

                @Override
                protected void process(List<Integer> chunks) {
                    int total = 0;
                    for ( Integer amtRead : chunks ) {
                        total += amtRead;
                    }
                    progress.setValue(progress.getValue() + total);
                }

                @Override
                protected void done() {
                    try {
                        byte[] data = get();
                        button.setText("Read " + data.length + " bytes");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            worker.execute();
        }
    });

    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());
    frame.add(button, BorderLayout.NORTH);
    frame.add(progress, BorderLayout.SOUTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack(); frame.setVisible(true);
}