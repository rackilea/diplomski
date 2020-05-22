import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

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
                frame.add(new LoginPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class LoginPane extends JPanel {

        public LoginPane() {
            setBackground(Color.WHITE);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 20, 4, 20);

            JLabel title = new JLabel("Log in to Pinterest");
            title.setFont(title.getFont().deriveFont(Font.BOLD, 18f));
            title.setBorder(new EmptyBorder(10, 0, 10, 0));

            add(title, gbc);
            add(new GroupPane(), gbc);
            gbc.insets = new Insets(4, 0, 4, 0);
            add(new JSeparator(JSeparator.HORIZONTAL), gbc);
            gbc.insets = new Insets(4, 20, 4, 20);
            add(new FieldPane(), gbc);
            gbc.insets = new Insets(4, 0, 0, 0);
            add(new ActionPane(), gbc);
        }

    }

    public class GroupPane extends JPanel {

        public GroupPane() {
            setOpaque(false);
            JPanel fbPane = new JPanel();
            JPanel goPane = new JPanel();
            JPanel twPane = new JPanel();

            fbPane.setBackground(Color.RED);
            goPane.setBackground(Color.BLUE);
            twPane.setBackground(Color.CYAN);

            fbPane.add(makeLabel("Log in with Facebook"));
            goPane.add(makeLabel("Log in with Google"));
            twPane.add(makeLabel("Log in with Twitter"));

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 0, 4, 0);

            add(fbPane, gbc);
            add(goPane, gbc);
            add(twPane, gbc);
        }

        protected JLabel makeLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(Color.WHITE);
            label.setFont(label.getFont().deriveFont(Font.BOLD, 14f));
            return label;
        }

    }

    public class FieldPane extends JPanel {

        private JTextField email;
        private JPasswordField password;

        public FieldPane() {
            setOpaque(false);
            email = new JTextField(10);
            password = new JPasswordField(10);

            email.setBackground(new Color(225, 225, 225));
            password.setBackground(new Color(225, 225, 225));

            Font font = email.getFont().deriveFont(Font.PLAIN, 24f);
            email.setFont(font);
            password.setFont(font);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 0, 4, 0);

            add(email, gbc);
            add(password, gbc);

            JLabel label = new JLabel("Are you a business? Get started here");
            label.setFont(label.getFont().deriveFont(Font.PLAIN, 10f));
            gbc.insets.left = 4;
            add(label, gbc);
        }

    }

    public class ActionPane extends JPanel {

        public ActionPane() {
            setBorder(new EmptyBorder(10, 20, 10, 20));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.anchor = GridBagConstraints.WEST;

            add(makeLabel("Forgot your password?"), gbc);
            gbc.gridy++;
            add(makeLabel("Sign up now"), gbc);

            gbc.gridx++;
            gbc.gridy = 0;
            gbc.gridheight = 2;
            gbc.ipady = 10;
            gbc.anchor = GridBagConstraints.EAST;
            JButton login = new JButton("Log in");
            add(login, gbc);
        }

        protected JLabel makeLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(Color.DARK_GRAY);
            return label;
        }

    }

}