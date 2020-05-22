import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameDemo {

    public static void main(String s[]) {
        JFrame frame = new JFrame("JFrame Source Demo");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JLabel jlbempty = new JLabel("");
        jlbempty.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(jlbempty, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}