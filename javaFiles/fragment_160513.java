import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginRequest extends JDialog{
    /**You can add, JTextFields, JLabel, JPasswordField..**/
    JPanel panel = new JPanel();
    JButton btnLogin = new JButton("Login");

    public LoginRequest(final MainFrame mf) {
        setTitle("Login");
        panel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Put some login logic here
                mf.frame.getContentPane().removeAll();
                mf.frame.add(mf.workspacePanel);
                mf.frame.repaint();
                mf.frame.revalidate();
                dispose();
            }
        });
        add(panel, BorderLayout.CENTER);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
    }
}