import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class GameStartJPanel extends JPanel {
    private final static int WIDTH = 400, HEIGHT = 400;

    private final static Rectangle left = new Rectangle(0, 0, WIDTH / 10, HEIGHT);
    private final static Rectangle right = new Rectangle((WIDTH / 10) * 9, 0, WIDTH / 5, HEIGHT);
    private final static Rectangle top = new Rectangle(0, 0, WIDTH, HEIGHT / 8);
    private final static Rectangle bottom = new Rectangle(0, (HEIGHT / 15) * 14, WIDTH, HEIGHT / 9);

    private final static Rectangle topInr = new Rectangle((WIDTH / 11) * 2, (HEIGHT / 16) * 3, (WIDTH / 14) * 9,
                HEIGHT / 10);
    private final static Rectangle bottomInr = new Rectangle((WIDTH / 11) * 2, (HEIGHT / 16) * 12, (WIDTH / 14) * 9,
                HEIGHT / 10);
    private final static Rectangle leftInr = new Rectangle((WIDTH / 11) * 2, HEIGHT / 5, WIDTH / 5, (HEIGHT / 10) * 6);
    private final static Rectangle rightInr = new Rectangle((WIDTH / 12) * 6, (HEIGHT / 20) * 7, WIDTH / 2,
                (HEIGHT / 10) * 3);
    private final static Rectangle finishLine = new Rectangle(WIDTH / 10, (HEIGHT / 10) * 8, WIDTH / 10, HEIGHT / 70);

    private final static Rectangle checkPoint = new Rectangle((WIDTH / 25) * 9, (HEIGHT / 10) * 5, WIDTH / 7, HEIGHT / 70);

    private final static Rectangle carOne = new Rectangle(WIDTH / 8, HEIGHT / 2, WIDTH / 30, WIDTH / 30);
    private final static Rectangle carTwo = new Rectangle(WIDTH / 9, HEIGHT / 2, WIDTH / 30, WIDTH / 30);

    private BufferedImage backgroundImage;

    public GameStartJPanel() {
        backgroundImage = createBackgroundImage();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private BufferedImage createBackgroundImage() {
        BufferedImage bckgdImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D gd = bckgdImage.createGraphics();
        try {

            gd.clearRect(0, 0, WIDTH, HEIGHT);

            gd.setColor(Color.RED);
            gd.fillRect(finishLine.x, finishLine.y, finishLine.width, finishLine.height);

            gd.setColor(Color.LIGHT_GRAY);
            gd.fillRect(left.x, left.y, left.width, left.height);
            gd.fillRect(right.x, right.y, right.width, right.height);
            gd.fillRect(top.x, top.y, top.width, top.height);
            gd.fillRect(bottom.x, bottom.y, bottom.width, bottom.height);

            gd.fillRect(topInr.x, topInr.y, topInr.width, topInr.height);
            gd.fillRect(bottomInr.x, bottomInr.y, bottomInr.width, bottomInr.height);
            gd.fillRect(leftInr.x, leftInr.y, leftInr.width, leftInr.height);
            gd.fillRect(rightInr.x, rightInr.y, rightInr.width, rightInr.height);

            // do this in the paintComponent method
            // gd.setColor(Color.GREEN);
            // gd.draw(carOne);
            // gd.setColor(Color.PINK);
            // gd.draw(carTwo);
        } finally {
            gd.dispose();
        }

        return bckgdImage;
    }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (backgroundImage != null) {
          g.drawImage(backgroundImage, 0, 0, null);
      }

      Graphics2D g2 = (Graphics2D) g;
      g.setColor(Color.GREEN);
      g2.draw(carOne);
      g.setColor(Color.PINK);
      g2.draw(carTwo);
   }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("GameStartJPanel");
        frame.getContentPane().add(new GameStartJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}