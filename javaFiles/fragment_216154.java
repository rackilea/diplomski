import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Relative Panel");
        JPanel panel = new JPanel(new MigLayout("", "", "[grow 70][grow 30]"));

        JButton Button1 = new JButton("Button 1");
        Button1.setPreferredSize(new Dimension(200,70));
        panel.add(Button1, "push,align 50% 71%, wrap");

        JButton Button2 = new JButton("Button 2");
        Button2.setPreferredSize(new Dimension(200,70));
        panel.add(Button2, "split,align 50% 33%");

        JButton Button3 = new JButton("Button 3");
        Button3.setPreferredSize(new Dimension(200,70));
        panel.add(Button3, "push,align 50% 33%");

        frame.add(panel);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}