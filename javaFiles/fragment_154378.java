public class ProgressBarDemo extends JFrame {
    private final JProgressBar progressBar = new JProgressBar(0, 100);
    private int progressCounter = 0;

    public ProgressBarDemo() {
        setContentPane(progressBar);
        setPreferredSize(new Dimension(100, 100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        new Thread(new Runnable() {
            public void run() {
                while (progressCounter <= 100) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            progressBar.setValue(progressCounter++);
                        }
                    });
                    try { Thread.sleep(500); } catch (InterruptedException e) {}
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProgressBarDemo().setVisible(true);
            }
        });
    }
}