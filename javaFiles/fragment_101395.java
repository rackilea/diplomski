import java.awt.CardLayout;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JavaApplication101 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BankGUI object1;
                object1 = new BankGUI();
                object1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                object1.pack();
                object1.setLocationRelativeTo(null);
                object1.setVisible(true);
            }
        });
    }

    public interface BankNavigationController {

        public void setView(String command);
    }

    public static class CardLayoutBankNavigationController implements BankNavigationController {

        private Container parent;
        private CardLayout layout;

        public CardLayoutBankNavigationController(Container parent, CardLayout layout) {
            this.parent = parent;
            this.layout = layout;
        }

        @Override
        public void setView(String command) {
            layout.show(parent, command);
        }

    }

    public static class BankGUI extends JFrame {

        private CardLayoutBankNavigationController controller;

        public BankGUI() {
            super("Banking App");
            CardLayout layout = new CardLayout();
            setLayout(layout);
            controller = new CardLayoutBankNavigationController(getContentPane(), layout);

            add("Main Menu", createMainMenu());
            add("Register", otherView("Register"));
            add("Login", otherView("Login"));
            add("About", otherView("About"));
            add("Exit", otherView("Exit"));

            controller.setView("Main Menu");
        }

        public JPanel otherView(String named) {
            JPanel view = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            view.add(new JLabel(named), gbc);

            JButton mainMenu = new JButton("Main Menu");
            view.add(mainMenu, gbc);

            ButtonListener actionListener = new ButtonListener(controller);
            mainMenu.addActionListener(actionListener);

            return view;
        }

        public JPanel createMainMenu() {
            JPanel menu = new JPanel();
            menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));

            menu.add(Box.createRigidArea(new Dimension(0, 40)));
            JLabel IntroText = new JLabel("Banking Application");
            IntroText.setMaximumSize(new Dimension(280, 60));
            IntroText.setFont(new Font("Serif", Font.PLAIN, 34));
            IntroText.setAlignmentX(CENTER_ALIGNMENT);
            menu.add(IntroText);

            menu.add(Box.createRigidArea(new Dimension(0, 40)));

            JButton CreateAccount = new JButton("Register");
            CreateAccount.setMaximumSize(new Dimension(200, 50));
            CreateAccount.setFont(new Font("Serif", Font.PLAIN, 24));
            CreateAccount.setAlignmentX(CENTER_ALIGNMENT);
            CreateAccount.setFocusable(false);
            menu.add(CreateAccount);

            menu.add(Box.createRigidArea(new Dimension(0, 20)));

            JButton LoginAccount = new JButton("Login");
            LoginAccount.setMaximumSize(new Dimension(200, 50));
            LoginAccount.setFont(new Font("Serif", Font.PLAIN, 24));
            LoginAccount.setAlignmentX(CENTER_ALIGNMENT);
            LoginAccount.setFocusable(false);
            menu.add(LoginAccount);

            menu.add(Box.createRigidArea(new Dimension(0, 20)));

            JButton AboutButton = new JButton("About");
            AboutButton.setMaximumSize(new Dimension(200, 50));
            AboutButton.setFont(new Font("Serif", Font.PLAIN, 24));
            AboutButton.setAlignmentX(CENTER_ALIGNMENT);
            AboutButton.setFocusable(false);
            menu.add(AboutButton);

            menu.add(Box.createRigidArea(new Dimension(0, 20)));

            JButton ExitButton = new JButton("Exit");
            ExitButton.setMaximumSize(new Dimension(200, 50));
            ExitButton.setFont(new Font("Serif", Font.PLAIN, 24));
            ExitButton.setAlignmentX(CENTER_ALIGNMENT);
            ExitButton.setFocusable(false);
            menu.add(ExitButton);

            ButtonListener actionListener = new ButtonListener(controller);
            CreateAccount.addActionListener(actionListener);
            LoginAccount.addActionListener(actionListener);
            AboutButton.addActionListener(actionListener);
            ExitButton.addActionListener(actionListener);

            return menu;
        }
    }

    public static class ButtonListener implements ActionListener {

        private BankNavigationController controller;

        public ButtonListener(BankNavigationController controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.setView(e.getActionCommand());
        }

    }

}