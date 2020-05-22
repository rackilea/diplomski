import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TransparencyTest {

    private static Point startPoint = new Point();
    private static Point endPoint = new Point();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                new TransparencyTest().test();
            }
        });
    }

    @SuppressWarnings("serial")
    private void test() {
        int alphaValue = 128;

        JFrame myFrame = new JFrame();
        myFrame.setUndecorated(true);
        myFrame.setBackground(new Color(0, 0, 0, alphaValue));
//      myFrame.setOpacity(0.1f);
        myFrame.setSize(800, 800);
        myFrame.setLocation(100, 100);

        JPanel myPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                System.out.println("PAINT");
                g.setColor(new Color(255, 0, 0, 255));
                if (startPoint.equals(new Point())) {
                    System.out.println("MIDDLE");
                    g.drawRect(200, 200, 400, 400);
                } else {
                    System.out.println("DRAW");
                    g.drawRect(
                            (int) Math.min(startPoint.getX(), endPoint.getX()),
                            (int) Math.min(startPoint.getY(), endPoint.getY()),
                            (int) Math.abs(startPoint.getX() - endPoint.getX()),
                            (int) Math.abs(startPoint.getY() - endPoint.getY())
                    );
                }
            }
        };
        myPanel.setOpaque(false);
        myFrame.add(myPanel);

        MouseAdapter myMouseAdapter = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }

            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                myPanel.repaint();
            }
        };
        myPanel.addMouseListener(myMouseAdapter);
        myPanel.addMouseMotionListener(myMouseAdapter);

        myFrame.setVisible(true);
    }
}