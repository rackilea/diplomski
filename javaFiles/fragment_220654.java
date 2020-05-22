import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;


public class Dialoger
{
    public static void main(String[] args)
    {
        Dialoger dialoger = new Dialoger();
        dialoger.go();
    }

    public void go()
    {
        JDialog jd = new JDialog();
        JButton one = new JButton("one");
        JButton two = new JButton("two");
        JButton three = new JButton("three");
        JPanel panel = new JPanel();
        panel.add(one);
        panel.add(two);
        panel.add(three);
        jd.add(panel, BorderLayout.SOUTH);
        jd.pack();
        jd.setVisible(true);
    }

}