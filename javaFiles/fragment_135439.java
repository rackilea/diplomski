import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    protected void initUI() {
        JFrame frame = new JFrame("Insets technique");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Insets i = frame.getInsets();
        System.out.println(i);
        Rectangle bounds = new Rectangle(50, 100, 400, 500);
        bounds.width += i.right + i.left;
        bounds.height += i.bottom + i.top;
        frame.setBounds(bounds);
    }

    protected void initUI2() {
        JFrame frame = new JFrame("Preferred size technique");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 500);
            }
        });
        frame.pack();
        frame.setLocation(50, 100);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test test = new Test();
                test.initUI();
                test.initUI2();
            }
        });
    }
}