import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

                JPanel left = new TestPane();
                JPanel right = new TestPane();

                left.setBackground(Color.RED);
                right.setBackground(Color.BLUE);

                left.setName("left");
                right.setName("right");

                MouseListener listener = new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(((JPanel)e.getSource()).getName());
                    }
                };

                left.addMouseListener(listener);
                right.addMouseListener(listener);

                JFrame frame = new JFrame("Testing");
                frame.setLayout(new GridLayout(0, 2));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(left);
                frame.add(right);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}