import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

        private ButtonGroup bg;

        public TestPane() {

            JRadioButton red = new JRadioButton("Red");
            red.setActionCommand("Red");
            JRadioButton blue = new JRadioButton("Blue");
            blue.setActionCommand("Blue");
            JRadioButton green = new JRadioButton("Green");
            green.setActionCommand("Green");

            bg = new ButtonGroup();
            bg.add(red);
            bg.add(blue);
            bg.add(green);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.WEST;
            add(red, gbc);
            add(blue, gbc);
            add(green, gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            JButton select = new JButton("OK");
            add(select, gbc);

            select.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ButtonModel model = bg.getSelection();
                    String selection = model == null ? "Nothing" : model.getActionCommand();
                    JOptionPane.showMessageDialog(TestPane.this, "You selected " + selection);
                }
            });

        }

    }

}