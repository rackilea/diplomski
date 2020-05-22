import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

    private static JTextField nameField = new JTextField(20);
    private static JTextField surnameField = new JTextField();
    private static JTextField addr1Field = new JTextField();
    private static JTextField addr2Field = new JTextField();
    private static JComboBox sizes = new JComboBox(new String[] { "small", "medium", "large", "extra-large" });

    public Main(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        getContentPane().add(mainPanel);

        JPanel addrPanel = new JPanel(new GridLayout(0, 1));
        addrPanel.setBorder(BorderFactory.createTitledBorder("Receiver"));
        addrPanel.add(new JLabel("Name"));
        addrPanel.add(nameField);
        addrPanel.add(new JLabel("Surname"));
        addrPanel.add(surnameField);
        addrPanel.add(new JLabel("Address 1"));
        addrPanel.add(addr1Field);
        addrPanel.add(new JLabel("Address 2"));
        addrPanel.add(addr2Field);
        mainPanel.add(addrPanel);
        mainPanel.add(new JLabel(" "));
        mainPanel.add(sizes);

        String[] buttons = { "OK", "Cancel"};

        int c = JOptionPane.showOptionDialog(
                null,
                mainPanel,
                "My Panel",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                buttons,
                buttons[0]
         );

        if(c ==0){
            new Envelope(nameField.getText(), surnameField.getText(), addr1Field.getText()
                    , addr2Field.getText(), sizes.getSelectedIndex());
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}