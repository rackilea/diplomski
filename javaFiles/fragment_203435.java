import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MySystemGUI implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JFrame myFrame;
    private JTextField LLName, LLAddress, LLPhone, LLbankDeets;
    private JButton sub1;
    private JLabel LLNameT, LLAddressT, LLPhoneT, LLbankDeetsT;

    private JPanel LLJP() {

        JPanel JP1 = new JPanel(new GridLayout(0, 2));

        LLNameT = new JLabel("Enter Landlord name");
        LLName = new JTextField(30);
        LLAddressT = new JLabel("Enter Landlord Address ");
        LLAddress = new JTextField(40);
        LLPhoneT = new JLabel("Enter Landlod Phone No.");
        LLPhone = new JTextField(10);
        LLbankDeetsT = new JLabel("Enter Landlod Bank details");
        LLbankDeets = new JTextField(10);
        sub1 = new JButton("Submit");

        JP1.add(LLNameT);
        JP1.add(LLName);
        JP1.add(LLAddressT);
        JP1.add(LLAddress);
        JP1.add(LLPhoneT);
        JP1.add(LLPhone);
        JP1.add(LLbankDeetsT);
        JP1.add(LLbankDeets);
        JP1.add(sub1);

        return JP1;

    }

    public MySystemGUI() {
        myFrame = new JFrame();
        JPanel myPanel = LLJP();
        myFrame.add(myPanel);
        myFrame.setTitle("My System GUI");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setBackground(Color.blue);
        myFrame.pack();
        myFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MySystemGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e){}
}