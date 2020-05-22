import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GridTest {

    public static void main(String[] args) {
        new GridTest();
    }

    public GridTest() {
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
            setLayout(new GridLayout(11, 11));

            for (int row = 0; row < 11; row++) {
                if (row > 0) {
                    add(new JLabel(Character.toString((char) (('A' + row) - 1))));
                } else {
                    add(new JLabel(" "));
                }
                for (int col = 0; col < 10; col++) {
                    if (row == 0) {
                        add(new JLabel(Integer.toString(col + 1)));
                    } else {
                        add(new JButton(" "));
                    }
                }
            }
        }

    }

}