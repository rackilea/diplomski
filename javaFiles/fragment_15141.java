import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
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

        JButton left;
        JButton right;
        JPanel paintPane;

        public TestPane() {
            JButton left = new JButton("left");
            left.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                }
            });
            JButton right = new JButton("right");
            right.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });

            paintPane = new PaintPane();

            setLayout(new BorderLayout());
            add(left, BorderLayout.WEST);
            add(right, BorderLayout.EAST);
            add(paintPane);
        }

    }

    public class PaintPane extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            Graphics2D g1 = (Graphics2D) g;
            g1.drawOval(3, 5, 45, 46); // The ball
            g1.fillOval(20, 30, 40, 40);

        }
    }

}