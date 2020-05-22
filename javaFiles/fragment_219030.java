import java.awt.*;
import javax.swing.*;

public class ChickenChopOrderingSystem {

    JFrame frame;
    JPanel mainPanel, p1, p2, p3, p4;
    JLabel lblTitle, lblName, lblPhoneNum, lblFlavour, lblChickenPart;
    JTextField txtName, txtPhoneNum;
    String flavour[] = {"Black Pepper Sauce", "Hainanese", "Grilled", "Lemon"};
    JComboBox box;
    ButtonGroup bg = new ButtonGroup();
    JRadioButton btnWhole, btnHalf, btnQuarter;
    JButton btnDone, btnExit;

    public ChickenChopOrderingSystem() {
        frame = new JFrame("Chicken Chop Ordering System");
        mainPanel = new JPanel();
        // GUESSWORK! 
        //mainPanel.setPreferredSize(new Dimension(700,700));
        mainPanel.setBackground(Color.yellow);

        lblName = new JLabel("Customer's Name: ");
        txtName = new JTextField(20);

        lblPhoneNum = new JLabel("Phone Number: ");
        txtPhoneNum = new JTextField(11);

        lblChickenPart = new JLabel("Select Part of Chicken: ");
        btnWhole = new JRadioButton("Whole");
        btnHalf = new JRadioButton("Half");
        btnQuarter = new JRadioButton("Quarter");
        bg.add(btnWhole);
        bg.add(btnHalf);
        bg.add(btnQuarter);

        lblFlavour = new JLabel("Select a flavour: ");
        box = new JComboBox(flavour);

        btnDone = new JButton("Done");
        btnExit = new JButton("Exit");

        //GridBaglayout
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        int s = 20;
        gbc.insets = new Insets(s,s,s,s);

        //Label
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        mainPanel.add(lblName, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        mainPanel.add(lblPhoneNum, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        mainPanel.add(lblChickenPart, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        mainPanel.add(lblFlavour, gbc);

        //TextField
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        mainPanel.add(txtName, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        mainPanel.add(txtPhoneNum, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 1d/6d;
        mainPanel.add(btnWhole, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        mainPanel.add(btnHalf, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        mainPanel.add(btnQuarter, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        mainPanel.add(box, gbc);

        //frame setting
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.add(mainPanel, new GridBagConstraints());
        // GUESSWORK! 
        //frame.setSize(new Dimension(1000, 1000));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ChickenChopOrderingSystem run = new ChickenChopOrderingSystem();
    }
}