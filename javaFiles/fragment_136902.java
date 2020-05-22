import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddressBook implements ActionListener {

    private CardLayout contentPaneLayout;
    private JButton b1 = new JButton("Create a New Address"), b2 = new JButton("Load Contacts"), b3 = new JButton("Add New Contacts"),
            b4 = new JButton("View/Delete Contacts"), b5 = new JButton("Backup Contacts"), b6 = new JButton("Exit"), b7 = new JButton("Cancel");
    private JTextField tf1 = new JTextField(13), tf2 = new JTextField(13);
    private JLabel l1 = new JLabel("Use The Buttons Below To Manage Contacts", JLabel.CENTER), l2 = new JLabel("This is Card 2"), l3 = new JLabel("Username:", JLabel.CENTER),
            l4 = new JLabel("Number of Contacts:", JLabel.CENTER);

    private Container contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddressBook();
            }
        });
    }

    public AddressBook() {
        JFrame frm = new JFrame("Address Book");
        contentPane = frm.getContentPane();
        contentPaneLayout = new CardLayout();
        contentPane.setLayout(contentPaneLayout);
        JPanel one = new JPanel(new GridLayout(5, 5));
        JPanel two = new JPanel(new GridLayout(4, 6));

        JPanel oneTwo = new JPanel(new FlowLayout());
        JPanel oneThree = new JPanel(new GridLayout(2, 3, 6, 5));
        JPanel oneFour = new JPanel(new GridLayout());
        JPanel oneFive = new JPanel(new GridLayout());

        one.add(l1);
        oneTwo.add(l3);
        oneTwo.add(tf1);
        tf1.setEditable(false);
        tf2.setEditable(false);
        oneTwo.add(l4);
        oneTwo.add(tf2);

        one.add(oneFive);
        one.add(oneTwo);
        oneThree.add(b1);
        oneThree.add(b2);
        oneThree.add(b3);
        oneThree.add(b4);
        oneThree.add(b5);
        oneThree.add(b6);
        one.add(oneFour);
        one.add(oneThree);

        two.add(l2);
        two.add(b7);

        contentPane.add("Card 1", one);
        contentPane.add("Card 2", two);
        //contentPaneLayout.show(contentPane, "Card 1");

        b1.addActionListener(this);
        b7.addActionListener(this);
        b6.addActionListener(this);
        frm.pack();
        frm.setSize(550, 250);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object click = e.getSource();
        System.out.println("...");
        if (click == b1) {
            contentPaneLayout.show(contentPane, "Card 2");
        }

        if (click == b6) {
            System.exit(0);
        }
        if (click == b7) {
            contentPaneLayout.show(contentPane, "Card 1");
        }

    }

}