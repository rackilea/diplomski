import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JButton;
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
            setLayout(new GridBagLayout());
            JButton[] button = new JButton[5];
            JPanel buttonPanelS = new JPanel();
            buttonPanelS.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            for (int i = 0; i < 5; i++) {
                button[i] = new JButton(random());
                button[i].setMargin(new Insets(0, 0, 0, 0));
                buttonPanelS.add(button[i], gbc);
            }
            add(buttonPanelS);
        }

        private Random rnd = new Random();

        public String random() {
            int length = rnd.nextInt(20) + 1;
            StringBuilder sb = new StringBuilder(length);
            for (int index = 0; index < length; index++) {
                sb.append(('a' + rnd.nextInt(52)));
            }
            return sb.toString();
        }

    }

}