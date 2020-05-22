import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BlockTheFrame {

    private JComponent ui = null;
    private CardLayout cardLayout;

    BlockTheFrame() {
        initUI();
    }

    public final void initUI() {
        if (ui != null) {
            return;
        }

        cardLayout = new CardLayout();
        ui = new JPanel(cardLayout);
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        JLabel login = new JLabel("Log in");
        login.setFont(login.getFont().deriveFont(200f));
        ui.add(login, "login");

        ui.add(new JLabel("logged in"), "loggedin");
    }

    public void login() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(
                0, 0, 1, 1, 0, 0,
                GridBagConstraints.BASELINE_TRAILING,
                GridBagConstraints.NONE, 
                new Insets(5, 5, 5, 5), 4, 6);
        loginPanel.add(new JLabel("ID"), gbc);
        gbc.gridy = 1;
        loginPanel.add(new JLabel("Password"), gbc);
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.gridx = 1;
        gbc.gridy = 0;
        loginPanel.add(new JTextField("enter ID", 10), gbc);
        gbc.gridy = 1;
        loginPanel.add(new JPasswordField(6), gbc);

        int result = JOptionPane.showConfirmDialog(
                ui, loginPanel, "LogIn", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // here a real app would check the results of the ID/password
            cardLayout.show(ui, "loggedin");
        }
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                BlockTheFrame o = new BlockTheFrame();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
                o.login();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}