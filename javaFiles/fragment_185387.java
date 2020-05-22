import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AuctionClient {
    public AuctionClient() {
        JFrame guiFrame = new JFrame();
        JPanel guiPanel = new JPanel(new GridBagLayout());
        JLabel userNameLabel = new JLabel("UserName:");
        JTextField userNameTextField = new JTextField(30);

        JLabel passwordLabel = new JLabel("Password:");
        JTextField passwordTextField = new JPasswordField(30);

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Auction Client");
        guiFrame.setSize(500, 250);

        guiFrame.setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        guiPanel.add(userNameLabel, labelGBC);
        guiPanel.add(userNameTextField, fieldGBC);

        guiPanel.add(passwordLabel, labelGBC);
        guiPanel.add(passwordTextField, fieldGBC);

        guiFrame.add(guiPanel, BorderLayout.NORTH);
        guiFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AuctionClient();
            }
        });
    }
}