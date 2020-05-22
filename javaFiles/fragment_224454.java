import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class CardLayoutTest {

    private static final String loginCard = "login";
    private static final String userCard = "createUser";

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel contentPane;

    public static void main(String[] args) {
        new CardLayoutTest();
    }

    public CardLayoutTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                createAndShowUI();
            }
        });
    }

    public void createAndShowUI() {
        frame = new JFrame("Welcome");
        cardLayout = new PageViewer();
        contentPane = new JPanel(cardLayout);

        LoginPage lp = new LoginPage();
        CreateUser cu = new CreateUser();

        lp.register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewUser();
                frame.pack();
            }
        });

        contentPane.add(lp, loginCard);
        contentPane.add(cu, userCard);

        frame.add(contentPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(150, 150);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public void createNewUser() {
        cardLayout.show(contentPane, userCard);
    }

    public class LoginPage extends JPanel {

        Image image;
        ImageIcon imageIcon;

        JPanel userPanel;
        JPanel passwordPanel;
        JPanel buttonsPanel;
        JPanel fieldsPanel;

        JFrame frame;

        JLabel usernameLabel;
        JLabel passwordLabel;
        JLabel logo;

        JTextField usernameField;
        JPasswordField passwordField;

        JButton login;
        JButton register;

        public LoginPage() {
            image = Toolkit.getDefaultToolkit().getImage("image.jpg");
            imageIcon = new ImageIcon("image.jpg");

            userPanel = new JPanel();
            passwordPanel = new JPanel();
            buttonsPanel = new JPanel();
            fieldsPanel = new JPanel();

            usernameLabel = new JLabel("username:");
            passwordLabel = new JLabel("password:");
            logo = new JLabel(imageIcon);

            usernameField = new JTextField();
            passwordField = new JPasswordField();

            login = new JButton("Login");
            register = new JButton("Register");

            this.setLayout(new BorderLayout(10, 15));
            this.setBorder(new EmptyBorder(10, 10, 10, 10));
            fieldsPanel.setLayout(new BorderLayout());

            usernameField.setColumns(8);
            passwordField.setColumns(8);

            userPanel.add(usernameLabel);
            userPanel.add(usernameField);

            passwordPanel.add(passwordLabel);
            passwordPanel.add(passwordField);

            fieldsPanel.add(userPanel, BorderLayout.CENTER);
            fieldsPanel.add(passwordPanel, BorderLayout.SOUTH);

            buttonsPanel.add(login);
            buttonsPanel.add(register);

            this.add(logo, BorderLayout.NORTH);
            this.add(fieldsPanel, BorderLayout.CENTER);
            this.add(buttonsPanel, BorderLayout.SOUTH);
        }
    }

    public class CreateUser extends JPanel {

        JPanel userPanel;
        JPanel passPanel;
        JPanel repPassPanel;
        JPanel buttonsPanel;
        JPanel fieldsPanel;

        JLabel username;
        JLabel password;
        JLabel repPassword;

        JTextField userField;
        JPasswordField passField;
        JPasswordField repPassField;

        JButton acceptButton;
        JButton cancelButton;

        public CreateUser() {

            userPanel = new JPanel();
            passPanel = new JPanel();
            repPassPanel = new JPanel();
            buttonsPanel = new JPanel();
            fieldsPanel = new JPanel();

            username = new JLabel("username: ");
            password = new JLabel("password: ");
            repPassword = new JLabel("repeat password: ");

            userField = new JTextField();
            passField = new JPasswordField();
            repPassField = new JPasswordField();

            acceptButton = new JButton("Accept");
            cancelButton = new JButton("Cancel");

            userField.setColumns(8);
            passField.setColumns(8);
            repPassField.setColumns(8);

            userPanel.add(username);
            userPanel.add(userField);

            passPanel.add(password);
            passPanel.add(passField);

            repPassPanel.add(repPassword);
            repPassPanel.add(repPassField);

            buttonsPanel.add(acceptButton);
            buttonsPanel.add(cancelButton);

            fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));

            this.setLayout(new BorderLayout(10, 15));
            this.setBorder(new EmptyBorder(10, 10, 10, 10));

            fieldsPanel.add(userPanel);
            fieldsPanel.add(passPanel);
            fieldsPanel.add(repPassPanel);

            this.add(fieldsPanel, BorderLayout.CENTER);
            this.add(buttonsPanel, BorderLayout.SOUTH);
        }
    }

    public class PageViewer extends CardLayout {

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            Component current = findCurrentComponent(parent);
            if (current != null) {
                Insets insets = parent.getInsets();
                Dimension pref = current.getPreferredSize();
                pref.width += insets.left + insets.right;
                pref.height += insets.top + insets.bottom;
                return pref;
            }
            return super.preferredLayoutSize(parent);
        }

        public Component findCurrentComponent(Container parent) {
            for (Component comp : parent.getComponents()) {
                if (comp.isVisible()) {
                    return comp;
                }
            }
            return null;
        }
    }
}