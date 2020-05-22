import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Form extends JFrame {

    JPanel pnl = new JPanel();
    JPanel pnl1 = new JPanel();
    JLabel fname = new JLabel("First name: ");
    JLabel lname = new JLabel("Last name: ");
    JLabel contact = new JLabel("Contact number: ");
    JLabel email = new JLabel("Email address: ");
    JLabel address = new JLabel("Address: ");
    JLabel numpsns = new JLabel("Number of persons: ");
    JTextField fnameField = new JTextField(25);
    JTextField lnameField = new JTextField(25);
    JTextField contactField = new JTextField(25);
    JTextField emailField = new JTextField(25);
    JTextArea txtadd = new JTextArea(5, 25);

    SpinnerModel sm = new SpinnerNumberModel(1, 0, 30, 1);
    JSpinner spinner = new JSpinner(sm);

    public Form() {

        this.setTitle("Reservation Form");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = gbc.HORIZONTAL;

        Border border = new CompoundBorder(
                new TitledBorder(null, "Customer Details", TitledBorder.CENTER, TitledBorder.TOP, null, null),
                new EmptyBorder(10, 10, 10, 10));

        pnl.setBorder(border);
        getContentPane().add(pnl, gbc);

        pnl.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //first column of the grid//
        gc.anchor = GridBagConstraints.EAST;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;

        pnl.add(fname, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        pnl.add(lname, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        pnl.add(contact, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        pnl.add(email, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        pnl.add(address, gc);

        //second column//
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 0;
        pnl.add(fnameField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        pnl.add(lnameField, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        pnl.add(contactField, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        pnl.add(emailField, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        pnl.add(txtadd, gc);

        //second Titled Border//        
        pnl1.setBorder(BorderFactory.createTitledBorder(null, "Booking Details", TitledBorder.CENTER, TitledBorder.CENTER));

        add(pnl1, gbc);

        pnl1.setLayout(new GridBagLayout());
        GridBagConstraints gc1 = new GridBagConstraints();

        //first column//
        gc1.weightx = 0.5;
        gc1.weighty = 0.5;

        gc1.gridx = 0;
        gc1.gridy = 0;

        pnl1.add(numpsns, gc1);

        gc1.anchor = GridBagConstraints.WEST;
        gc1.gridx = 1;
        gc1.gridy = 0;
        pnl1.add(spinner, gc1);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Form frame = new Form();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}