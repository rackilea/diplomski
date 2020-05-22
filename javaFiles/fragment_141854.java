public class LabelWorker extends JFrame {

    private class Task extends SwingWorker<Void, Integer> {

        @Override
        protected Void doInBackground() {
            val = 0;
            setProgress(0);
            while (val < 1000) {
                try {
                    Thread.sleep(60);
                } catch (InterruptedException ex) {
                }
                publish(val);
                setProgress((int) (val * 100. / 1000.));
                val++;
            }
            return null;
        }

        @Override
        protected void process(List<Integer> chunks) {
            progressLbl.setText(chunks.get(0).toString());
        }

        @Override
        public void done() {
            startBtn.setEnabled(true);
            setCursor(null);
            val = 1000;
        }
        private int val;

    }

    public LabelWorker() {
        setTitle("Worker");
        setLayout(new FlowLayout());
        startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionStart();
            }
        });
        stopBtn = new JButton("Stop");
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionStop();
            }
        });
        progressLbl = new JLabel("not running...");
        add(startBtn);
        add(stopBtn);
        add(progressLbl);
        pack();
    }

    private void actionStart() {
        Task task;
        startBtn.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        task = new Task();
        task.execute();
        t = task;
    }

    private void actionStop() {
        startBtn.setEnabled(true);
        setCursor(null);
        t.cancel(true);
    }

    public static void main(String[] args) {
        new LabelWorker().setVisible(true);
    }
    private final JButton startBtn;
    private final JButton stopBtn;
    private final JLabel progressLbl;
    private Task t;
}