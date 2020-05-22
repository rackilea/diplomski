public class Loading extends JPanel { 

    // Pictures
    private BufferedImage background;

    // -------------- Final Variables --------------
    private final int numOfFiles = 32;

    // -------------- Dynamic Variables --------------
    // Global Variables
    private double loadingPercentage = 0;

    private int numOfLoadedFiles = 0;

    public Loading() {
        background = XTestUtils.loadDefaultImage("moon.jpg");
        // Start the thread
        new Thread(new LoadingFiles()).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        for (int i = 0; i < loadingPercentage; i = i + 15) {
            g.setColor(new Color(20, 241, 47));
            g.drawRect(180 + (i / 15) * (50 + 10), 375, 50, 50);
        }
    }

    class LoadingFiles implements Runnable {
        @Override
        public void run() {

            while (numOfLoadedFiles < 32) {
                numOfLoadedFiles++;
                loadingPercentage = (double) numOfLoadedFiles / numOfFiles
                        * 100;
                repaint();
                try {
                    // simulate the loading
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JXFrame("", true);
        frame.add(new Loading());
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}