import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Demo {

    Scanner scan;
    static String Name, Surname;

    public void open() {

        try {
            scan = new Scanner(new File("C:/team1.txt"));
            System.out.println("it is working");
        } catch (FileNotFoundException e) {
            System.out.println("it is not working");
        }
    }

    public void Read() {
        do {
            Name = scan.next();

            if (scan.hasNext())
                Surname = scan.next();

        } while (scan.hasNext());
        System.out.println(Name + Surname);

        scan.close();
    }
}

public class DemoSwing implements ActionListener {
    private JTextField T = new JTextField(30);
    private JTextField T1 = new JTextField(30);
    private JFrame f = new JFrame("Demo");
    private JPanel p = new JPanel();
    private JButton B = new JButton("View");
    // Static variable
    static String N, S;

    public DemoSwing() {

        f.setVisible(true);
        f.setSize(500, 500);

        p.add(new JLabel("Name"));
        T.setEditable(false);
        p.add(T);

        p.add(new JLabel("Surname"));
        T1.setEditable(false);
        p.add(T1);

        B.addActionListener(this);
        p.add(B);

        f.add(p);
        // JFrame f.setLayout(new FlowLayout()); f.setSize(300,100);
        // f.setVisible(true);

    }

    public static void main(String[] args) {
        new DemoSwing();

        Demo f = new Demo();
        f.open();
        f.Read();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == B) {
            T.setText(Demo.Name);
            T1.setText(Demo.Surname);
        }
    }
}