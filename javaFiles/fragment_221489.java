import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class FrameTest {
    public static void main(String[] args) throws InterruptedException {

        JFrame jf = new JFrame("Demo");
        jf.getContentPane().setLayout(new GridLayout(9, 9, 3, 3));    

        for (int i = 0; i < 9*9; i++) {
            JTextField tf = new JTextField(1);
            tf.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            tf.setBackground(new Color(230, 230, 230));
            tf.setHorizontalAlignment(JTextField.CENTER);
            tf.setFont(tf.getFont().deriveFont(20f));
            jf.add(tf);
        }

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

    }
}