import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Example {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 200);
        // main panel
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(1, 2));
        pan.setBackground(Color.BLUE);
        jFrame.getContentPane().add(pan, BorderLayout.CENTER);
        jFrame.show();
        // left panel
        JPanel left = getContentPanel();
        left.setBackground(Color.ORANGE);
        pan.add(left);
        // right panel (with scroll pane)
        JPanel right = getContentPanel();
        right.setBackground(Color.YELLOW);
        JScrollPane scr = new JScrollPane(right);
        scr.setBackground(Color.CYAN);
        scr.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);
        scr.setAlignmentY(JScrollPane.TOP_ALIGNMENT);
        pan.add(scr);
    }

    private static JPanel getContentPanel() {
        JPanel rtn = new JPanel();

        rtn.setLayout(new BoxLayout(rtn, BoxLayout.Y_AXIS));

        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel("Item " + (i + 1));
            label.setBackground(Color.DARK_GRAY);
            rtn.add(label);
        }

        rtn.add(Box.createVerticalGlue());

        rtn.setBackground(Color.GREEN);
        return rtn;
    }

}