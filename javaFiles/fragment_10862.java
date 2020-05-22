import java.awt.Graphics;

public class FrameTest {

    public static void main(String[] args) {
        final JFrame f = new JFrame("Frame Test");
        f.setContentPane(new MyTreeComponent());
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    f.repaint();
                }
            }
        }.start();
    }
}

class MyTreeComponent extends JComponent {
    public void paintComponent(Graphics g) {
        // Draw your tree. (Using random here to visualize the updates.)
        g.drawLine(30, 30, 50, 30 + new Random().nextInt(20));
        g.drawLine(30, 30, 50, 30 - new Random().nextInt(20));
    }
}