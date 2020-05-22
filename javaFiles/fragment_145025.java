import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Buttons {
    public static void main(String[] args) {
        Buttons gui = new Buttons();
    }

    public Buttons() {
        // create frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(250, 150));
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        // create top panel with first four buttons
        JPanel panel1 = new JPanel(new GridLayout(2, 2));
        panel1.add(new JButton("Play"));
        panel1.add(new JButton("New Game"));
        panel1.add(new JButton("Save Game"));
        panel1.add(new JButton("Load Game"));

        // create bottom panel with "Options" button
        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(new JButton("Options"));

        // add panels to frame
        frame.add(panel1);
        frame.add(panel2);
    }   
}