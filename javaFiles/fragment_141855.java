public class ProgressingLabels extends JFrame {

    private class Loader implements Runnable {

        private final JLabel progress;

        public Loader(JLabel progress) {
            this.progress = progress;
            progress.setText("0");
        }

        @Override
        public void run() {
            int i = 0;
            while (i < 1000) {
                progress.setText(String.valueOf(++i));
                try {
                    TimeUnit.MILLISECONDS.sleep(60);
                } catch (InterruptedException ex) {
                    break;
                }
            }
        }
    }

    public ProgressingLabels() {
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        progressLabel = new JLabel("0     ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        startButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if ((wt == null) || (!wt.isAlive())) {
                    Loader ld = new Loader(progressLabel);
                    wt = new Thread(ld);
                    wt.start();
                } else {
                    JOptionPane.showMessageDialog(null, "Thread already running...");
                }
            }
        });
        add(startButton);

        stopButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if ((wt != null) && (wt.isAlive())) {
                    wt.interrupt();
                }
                JOptionPane.showMessageDialog(null, "Thread interrupted\n" + (progressLabel.getText()) + " rounds.");
            }
        });
        add(stopButton);

        add(progressLabel);

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProgressingLabels().setVisible(true);
            }
        });
    }

    private final JButton startButton;
    private final JButton stopButton;
    private JLabel progressLabel;
    private Thread wt;
}