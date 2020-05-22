import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame{
    JFrame frame = new JFrame("Main frame");

    JPanel welcomePanel = new JPanel();
    JPanel workspacePanel = new JPanel();
    JPanel cardPanel = new JPanel();

    JButton btnLogin = new JButton("Login");
    JLabel lblWelcome = new JLabel("Welcome");

    LoginRequest lr = new LoginRequest(this);

    public MainFrame() {
        welcomePanel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lr.setVisible(true);
            }
        });

        workspacePanel.add(lblWelcome);

        frame.getContentPane().add(welcomePanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(320,240));
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}