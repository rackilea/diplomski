import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class CompundLayout {

    public static void main(String[] args) {
        new CompundLayout();
    }

    public CompundLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {

            JPanel left = new JPanel();
            JPanel right = new JPanel();

            setLayout(new GridLayout(0, 2, 2, 2));

            left.add(createPane(Color.RED));
            left.add(createPane(Color.GREEN));
            right.add(createPane(Color.BLUE));
            right.add(createPane(Color.MAGENTA));

            add(left);
            add(right);

        }

        protected JPanel createPane(Color color) {

            SimplePane pane = new SimplePane();
            pane.setBorder(new LineBorder(color));

            return pane;

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }
    }

    public class SimplePane extends JPanel {

        private int width;
        private int height;

        public SimplePane() {

            width = 100;
            height = 50 + (int) Math.round(Math.random() * 100);

        }

        @Override
        public Dimension getPreferredSize() {

            return new Dimension(width, height);

        }

    }

}