import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Passon {

    public static void main(String[] args) {
        new Passon();
    }

    private JPanel basePane;
    private EditorPane editorPane;
    private DisplayPane displayPane;

    public Passon() {
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
                basePane = new JPanel(new CardLayout());
                basePane.add((editorPane = new EditorPane()), "Editor");
                basePane.add((displayPane = new DisplayPane()), "Display");
                ((CardLayout)basePane.getLayout()).show(basePane, "Editor");
                frame.add(basePane);

                JPanel buttons = new JPanel();
                JButton next = new JButton("Next >");
                buttons.add(next);
                frame.add(buttons, BorderLayout.SOUTH);

                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout layout = (CardLayout) basePane.getLayout();
                        displayPane.setUser(editorPane.getUser());
                        layout.show(basePane, "Display");
                        ((JButton)e.getSource()).setEnabled(false);
                    }
                });

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class User {

        private String name;
        private char[] password;

        public User(String name, char[] password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public char[] getPassword() {
            return password;
        }

    }

    public class EditorPane extends JPanel {

        private JTextField name;
        private JPasswordField password;

        public EditorPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(new JLabel("User: "), gbc);
            gbc.gridy++;
            add(new JLabel("Password: "), gbc);

            gbc.gridy = 0;
            gbc.gridx++;

            name = new JTextField(20);
            password = new JPasswordField(20);

            add(name, gbc);
            gbc.gridy++;
            add(password, gbc);        
        }

        public User getUser() {
            User user = new User(name.getText(), password.getPassword());
            return user;
        }

    }

    public class DisplayPane extends JPanel {

        private JLabel name;

        public DisplayPane() {
            name = new JLabel();
            setLayout(new GridBagLayout());
            add(name);
        }

        public void setUser(User user) {
            name.setText(user.getName());
        }            
    }
}