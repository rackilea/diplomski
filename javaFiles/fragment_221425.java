import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Rb extends JFrame {
    Rb() {
        JRadioButton male = new JRadioButton("male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup bG = new ButtonGroup();
        bG.add(male);
        bG.add(female);
        this.setSize(100, 200);
        this.setLayout(new FlowLayout());
        this.add(male);
        this.add(female);
        male.setSelected(true);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        Rb j = new Rb();
    }
}