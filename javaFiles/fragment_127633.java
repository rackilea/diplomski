import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class Q17_1 extends JFrame {

    JButton left = new JButton("<=");
    JButton right = new JButton("=>");
    JPanel p1 = new JPanel();
    JRadioButton rb1 = new JRadioButton("Red");
    JRadioButton rb2 = new JRadioButton("Yellow");
    JRadioButton rb3 = new JRadioButton("White");
    JRadioButton rb4 = new JRadioButton("Gray");
    JRadioButton rb5 = new JRadioButton("Green");
    JPanel p2 = new JPanel();
    JLabel m = new JLabel("Welcome to Java");
//  Message m = new Message("Welcome to Java");

    public Q17_1() {
        setLayout(new BorderLayout());

        p1.setBorder(new TitledBorder("Select Message Panel Background"));
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        group.add(rb4);
        group.add(rb5);
        rb1.setMnemonic('R');
        rb2.setMnemonic('Y');
        rb3.setMnemonic('W');
        rb4.setMnemonic('G');
        rb5.setMnemonic('N');

        p1.setLayout(new GridLayout(1, 5, 5, 5));
        p1.add(rb1);
        p1.add(rb2);
        p1.add(rb3);
        p1.add(rb4);
        p1.add(rb5);

        p2.setLayout(new FlowLayout());
        add(p1, BorderLayout.NORTH);
        add(m);
        p2.add(left);
        p2.add(right);

        add(p2, BorderLayout.SOUTH);

        left.addActionListener((ActionEvent) -> {
//          m.moveLeft();
//          repaint();
        });

        right.addActionListener((ActionEvent) -> {
//          m.moveRight();
//          repaint();
        });

//      rb1.addActionListener(m);
//      rb2.addActionListener(m);
//      rb3.addActionListener(m);
//      rb4.addActionListener(m);
//      rb5.addActionListener(m);
    }

    public static void main(String[] args) {
        Q17_1 frame = new Q17_1();
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}