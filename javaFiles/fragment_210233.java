import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;

public class Lottery extends JPanel {


    private static final long serialVersionUID = 5815877011755522230L;

    private JLabel label;

    public static void main(String[] args) {
        make();

    }

    public Lottery() {

        label = new JLabel("Hello There");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        //add(label);
        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);

    }

    public static void make(){
        JFrame frame = new JFrame("Lottery");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Lottery hi = new Lottery();
        frame.setContentPane(hi);

        frame.setSize(600, 600);
        frame.setVisible(true);

    }


}