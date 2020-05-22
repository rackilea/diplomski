import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Testing {
    //variables
    private JFrame f = new JFrame("GUI TEST");

    private JPanel p = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();
    private JPanel p6 = new JPanel();
    private JPanel p9 = new JPanel();
    private JPanel p10 = new JPanel();
    private JPanel p11 = new JPanel();

    private JButton b1 = new JButton("Button");

    private JTextField tf1 = new JTextField(12);
    private JTextField tf2 = new JTextField(12);
    private JTextField tf3 = new JTextField(12);

    private JTextArea ta1 = new JTextArea(10, 45);

    private JLabel label1 = new JLabel("Label 1");
    private JLabel label2 = new JLabel("Label 2");
    private JLabel label3 = new JLabel("Label 3");
    private JLabel label4 = new JLabel("Label 4");

    private JScrollBar sb1 = new JScrollBar(){

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(super.getPreferredSize().width, ta1.getPreferredSize().height);
        }
    };

    //class constructor
    public Testing() {
        gui();
    }

    public void gui() {
        p.add(label1);
        p.add(tf1);
        p2.add(label2);
        p2.add(tf2);
        p3.add(label3);
        p3.add(tf3);
        p4.add(sb1);
        p4.add(label4);
        p5.add(ta1);
        p6.add(b1);
        p4.setBackground(Color.GRAY);
        p9.setBackground(Color.GRAY);
        p10.setBackground(Color.GRAY);
        p11.setBackground(Color.GRAY);
        p9.add(p);
        p9.add(p2);
        p9.add(p3);
        p10.add(p5);
        p11.add(p6);
        //adds panels to frames
        f.add(p4, BorderLayout.EAST);
        f.add(p9, BorderLayout.NORTH);
        f.add(p10, BorderLayout.CENTER);
        f.add(p11, BorderLayout.PAGE_END);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Testing();
        });
    }
}