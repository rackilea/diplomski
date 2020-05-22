import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Login implements ActionListener {

    JPanel textPanel, panelForTextFields, completionPanel;
    JLabel titleLabel, usernameLabel, passwordLabel, userLabel, passLabel;
    JTextField usernameField, loginField;
    JButton loginButton;

//
    JComboBox colorChooser;
    JPanel redBox, blueBox, greenBox, yellowBox;

    public JPanel createContentPane() {

        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(new BorderLayout());

        //////////////////////////////////////////////////////////////////////
        // To create a JComboBox, we need to pass in an array of Strings.
        // This gives the ComboBox the list of selections you can make.
        String colors[] = {"Red", "Blue", "Green", "Yellow"};

        colorChooser = new JComboBox(colors);
        colorChooser.setSelectedIndex(1);
        colorChooser.addActionListener(this);

        // Now we create a simple JPanel that displays our four coloured boxes.
        JPanel boxPanel = new JPanel(new GridLayout(2, 2, 20, 20));

        redBox = createSquareJPanel(Color.red, 50);
        blueBox = createSquareJPanel(Color.blue, 50);
        greenBox = createSquareJPanel(Color.green, 50);
        yellowBox = createSquareJPanel(Color.yellow, 50);

        // This sets all bar the blue box to be hidden.
        redBox.setVisible(false);
        greenBox.setVisible(false);
        yellowBox.setVisible(false);

        boxPanel.add(redBox);
        boxPanel.add(blueBox);
        boxPanel.add(greenBox);
        boxPanel.add(yellowBox);

        // This sets the widgets on the screen to be layed out in a
        // top to bottom fashion with spacers inbetween.
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));

        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(colorChooser);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        bottomPanel.add(boxPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        totalGUI.add(bottomPanel, BorderLayout.SOUTH);

        JPanel loginPane = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        ////////////////////////////////////
        titleLabel = new JLabel("User Login Screen");
        titleLabel.setHorizontalAlignment(0);
        loginPane.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Username Label
        usernameLabel = new JLabel("Username");
        usernameLabel.setHorizontalAlignment(4);
        loginPane.add(usernameLabel, gbc);

        gbc.gridx++;

        // Username Textfield
        usernameField = new JTextField(8);
        loginPane.add(usernameField, gbc);

        gbc.gridx++;

        // Username Label
        userLabel = new JLabel("Wrong");
        userLabel.setForeground(Color.red);
        loginPane.add(userLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        // Login Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setHorizontalAlignment(4);
        loginPane.add(passwordLabel, gbc);

        gbc.gridx++;

        // Login Textfield
        loginField = new JTextField(8);
        loginPane.add(loginField, gbc);

        gbc.gridx++;

        // Login Label
        passLabel = new JLabel("Wrong");
        passLabel.setForeground(Color.red);
        loginPane.add(passLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Button for Logging in
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginPane.add(loginButton, gbc);

        totalGUI.add(loginPane);

        totalGUI.setOpaque(true);
        return totalGUI;
    }

// With this action performed, we simply check to see if the username and
// password match "Bob" as the username and "Robert" as the password.
// If they do, we set the labels ajacent to them to "Correct!" and color
// them green.
// At the end, we check if both labels are green. If they are, we set the
// screen to be 'Logging In'.
    public void actionPerformed(ActionEvent e) {
        int temp;

        if (e.getSource() == colorChooser) {
            temp = colorChooser.getSelectedIndex();

            switch (temp) {
                case 0:
                    redBox.setVisible(true);
                    blueBox.setVisible(false);
                    greenBox.setVisible(false);
                    yellowBox.setVisible(false);
                    break;
                case 1:
                    redBox.setVisible(false);
                    blueBox.setVisible(true);
                    greenBox.setVisible(false);
                    yellowBox.setVisible(false);
                    break;
                case 2:
                    redBox.setVisible(false);
                    blueBox.setVisible(false);
                    greenBox.setVisible(true);
                    yellowBox.setVisible(false);
                    break;
                case 3:
                    redBox.setVisible(false);
                    blueBox.setVisible(false);
                    greenBox.setVisible(false);
                    yellowBox.setVisible(true);
                    break;
            }
        }
        if (e.getSource() == loginButton) {
            if (usernameField.getText().trim().compareTo("Bob") == 0) {
                userLabel.setForeground(Color.green);
                userLabel.setText("Correct!");
            } else {
                userLabel.setForeground(Color.red);
                userLabel.setText("Wrong!");
            }

            if (loginField.getText().trim().compareTo("Robert") == 0) {
                passLabel.setForeground(Color.green);
                passLabel.setText("Correct!");
            } else {
                passLabel.setForeground(Color.red);
                passLabel.setText("Wrong!");
            }

            if ((userLabel.getForeground() == Color.green)
                    && (passLabel.getForeground() == Color.green)) {
                titleLabel.setText("Logging in....");
                loginButton.setEnabled(false);
            }
        }
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Login");

        Login demo = new Login();
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }

    private JPanel createSquareJPanel(Color color, int size) {
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(color);
        tempPanel.setMinimumSize(new Dimension(size, size));
        tempPanel.setMaximumSize(new Dimension(size, size));
        tempPanel.setPreferredSize(new Dimension(size, size));
        return tempPanel;
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}