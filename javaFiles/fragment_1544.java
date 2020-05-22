import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HashString {   // It seems that this isn't a JPanel. Rather, it is an application.

    JFrame frame;

    public void initialise() {

        frame = new JFrame("Test 1");   // You can create the frame of the application here and set title

        frame.setLocation(200, 200);
        frame.setSize(300, 300);

        JPanel contentPanel = new JPanel();     // To allow a border to be set, I've declared a content panel inside the
                                                // frame.
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));    // This sets a border to make everything look nice
        contentPanel.setLayout(new BorderLayout(5, 5)); // This creates the BorderLayout, which manages the layout of
                                                        // the components easily
        frame.setContentPane(contentPanel);

        JLabel instructionsLabel = new JLabel("Enter Your Strings separated by a comma, below. ");
        instructionsLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
        contentPanel.add(instructionsLabel, BorderLayout.NORTH);    // BorderLayout.NORTH tells the layout manager where
                                                                    // to put the component.

        JTextField txtField = new JTextField();
        txtField.setText("Enter Strings Here");
        contentPanel.add(txtField, BorderLayout.CENTER);

        JButton btn = new JButton("Enter These Values");
        btn.setFont(new Font("Times new roman", Font.BOLD, 12));
        btn.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                // Call whatever method that you want to call when this is relevant. Set textField and other variables
                // here. You can do things like 'txtField.setText( methodOperationOnString ( txtField.getText() ) )' or
                // something of the like.
            }
        });
        contentPanel.add(btn, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        // This tells it to create the entire thing on the GUI thread
        EventQueue.invokeLater(new Runnable() {
            @Override public void run() {
                HashString b = new HashString();
                b.initialise();
            }
        });
    }
}