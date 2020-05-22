import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.insets = new Insets(5, 10, 10, 10);
            JTextField jtf = new JTextField(2);
            jtf.setHorizontalAlignment(JTextField.CENTER);
            gbc.ipadx = 10;
            gbc.ipady = 10;
            gbc.gridy = 0;
            gbc.gridx = 0;
            jtf.setFocusable(false);
            add(jtf, gbc);

            gbc = new GridBagConstraints();
            try {
                JLabel jl = new JLabel();
                ImageIcon ii = new ImageIcon(ImageIO.read(getClass().getResource("/shield01.png")));
                jl.setIcon(ii);
                gbc.gridy = 0;
                gbc.gridx = 0;
                add(jl, gbc);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}