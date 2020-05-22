import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class Test extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                Test frame = new Test("Testing", 400, 400);
            }
        });
    }

    Test(String title, int x, int y) {

        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addElements();
        pack();
        setVisible(true);
//        setResizable(false);

    }

    public void addElements() {

        Font size30 = new Font(null, Font.PLAIN, 30);

        //--- User Info ---//
        JPanel userInfo = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 4, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel userLabel = new JLabel("Username: ");
        JTextField userField = new JTextField(12);
        userInfo.add(userLabel, gbc);
        gbc.gridx++;
        userInfo.add(userField, gbc);

        JLabel passLabel = new JLabel("Password: ");
        JTextField passField = new JTextField(10);
        gbc.gridx++;
        userInfo.add(passLabel, gbc);
        gbc.gridx++;
        userInfo.add(passField, gbc);

        JLabel serverLabel = new JLabel("Mail Server: ");
        JTextField serverField = new JTextField(10);
        gbc.gridx++;
        userInfo.add(serverLabel, gbc);
        gbc.gridx++;
        userInfo.add(serverField, gbc);

        JLabel portLabel = new JLabel("Server Port: ");
        JTextField portField = new JTextField(3);
        gbc.gridx++;
        userInfo.add(portLabel, gbc);
        gbc.gridx++;
        userInfo.add(portField, gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 4, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        //--- To: CC: and Subject Fields ---//
        JPanel msgInfo = new JPanel(new GridBagLayout());

        JLabel toLabel = new JLabel("To: ");
        JTextField toField = new JTextField(30);
        msgInfo.add(toLabel, gbc);
        gbc.gridx++;
        msgInfo.add(toField, gbc);

        JLabel subLabel = new JLabel("Subject: ");
        JTextField subField = new JTextField(30);
        gbc.gridx++;
        msgInfo.add(subLabel, gbc);
        gbc.gridx++;
        msgInfo.add(subField, gbc);

        //--- Body ---//
//        JPanel bodyPnl = new JPanel(new GridBagLayout());
//        gbc = new GridBagConstraints();
//        gbc.insets = new Insets(2, 2, 4, 2);
//        gbc.gridx = 0;
//        gbc.gridy = 0;

        JLabel bodyLabel = new JLabel("Body");
        bodyLabel.setHorizontalAlignment(JLabel.CENTER);
        bodyLabel.setFont(size30);

        JTextArea bodyField = new JTextArea(30, 70);
        bodyField.setLineWrap(true);
        bodyField.setWrapStyleWord(true);

        JScrollPane bodyScroll = new JScrollPane(bodyField);

        bodyScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        bodyScroll.setBounds(getX(), getY(), bodyField.getWidth(), bodyField.getHeight());

        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(userInfo, gbc);
        gbc.gridy++;
        add(msgInfo, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(10, 10, 4, 10);
        add(bodyLabel, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(4, 10, 10, 10);
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(bodyScroll, gbc);

    }

}