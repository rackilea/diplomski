import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class MainInterfaces extends JFrame implements ActionListener
{

    private JButton send;
    private JTextField to, subject, message;
    private JLabel toLbl, subjectLbl, messageLbl;


    public MainInterfaces() { 



        setLayout(new FlowLayout());
        toLbl = new JLabel("Recipient: ");
        subjectLbl = new JLabel("Subject: ");
        messageLbl = new JLabel("Message: ");

        to = new JTextField(32);
        subject = new JTextField(32);
        message = new JTextField(32);

        send = new JButton("SEND");

        add(toLbl);
        add(to);
        add(subjectLbl);
        add(subject);
        add(messageLbl);
        add(message);
        add(send);




    }

    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub

    }
}