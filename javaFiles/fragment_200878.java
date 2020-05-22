import java.awt.*;
import javax.swing.*;

class InputContextTest {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JTextField tf = new JTextField(10);
                System.out.println(tf.getInputContext());
                JOptionPane.showMessageDialog(null, tf);
                System.out.println(tf.getInputContext());
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}