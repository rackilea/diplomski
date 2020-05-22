import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setBackground(Color.RED);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int width = getWidth() - 20;
            int height = getHeight() - 20;

            Area area = new Area(new Rectangle(10, 10, width, height));

            int cellWidth = width / 4;
            int cellHeight = height / 4;

            for (int row = 0; row < 4; row++) {
                int yPos = 10 + (row * cellHeight);
                for (int col = 0; col < 4; col++) {
                    int xPos = 10 + (col * cellWidth);
                    area.subtract(new Area(new Ellipse2D.Double(xPos + 2, yPos + 2, cellWidth - 4, cellHeight - 4)));
                }
            }

            g2d.setColor(Color.BLUE);
            g2d.fill(area);
            g2d.dispose();
        }

    }

}