public class Main {
public static void main(String[] args) {
    final JFrame frame = new JFrame("TEST");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    final JLabel label = new JLabel();
    ImageIcon icon = null;

    try {
        icon = new ImageIcon(ImageIO.read(new File("C:\\images\\errorIcon.png")));
    } catch (IOException e) {
        e.printStackTrace();
    }

    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(label, BorderLayout.CENTER);
    frame.setSize(200,200);

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            frame.setVisible(true);
        }
    });


    try {
        Thread.currentThread().sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    final ImageIcon finalIcon = icon;
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            if(finalIcon != null && finalIcon.getImageLoadStatus() == MediaTracker.COMPLETE){
               label.setIcon(finalIcon);
            }
        }
    });
}