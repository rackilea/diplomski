import java.awt.Dimension;

import javax.swing.*;

public class Test extends JFrame{
    JPanel panel = new JPanel();
    JLabel lbl1 = new JLabel("First");
    JLabel lbl2 = new JLabel("Second");

    public Test(){
        super("BoxLayout Test");
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(new Dimension(300,200));
        panel.add(lbl1);
        panel.add(lbl2);
        add(panel);

    }
    public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                Test t = new Test();
                t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                t.pack();
                t.setVisible(true);
        }});
    }
}