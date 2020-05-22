import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicArrowButton;

public class BasicArrowButtonTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frm = new JFrame("Test arrow button");
                JPanel p = new JPanel(new GridLayout(1, 1));
                p.setPreferredSize(new Dimension(100, 100));
                p.add(new BasicArrowButton(BasicArrowButton.WEST));
                frm.add(p);
                frm.pack();
                frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
        });
    }
}