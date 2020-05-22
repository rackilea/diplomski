import java.awt.*;
import javax.swing.*;

class BigInputOptionPane {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                String s = JOptionPane.showInputDialog(null);
                if (s!=null) {
                    System.out.println("User chose: " + s);
                } else {
                    System.out.println("User did not chose an option!");
                }

                JTextField tf = new JTextField(8);
                tf.setFont(tf.getFont().deriveFont(26f));
                int result = JOptionPane.showConfirmDialog(
                        null, tf, "Input", 
                        JOptionPane.OK_CANCEL_OPTION);
                if (result==JOptionPane.OK_OPTION) {
                    System.out.println("User chose: " + tf.getText());
                } else {
                    System.out.println("User did not chose an option!");
                }
            }
        };
        SwingUtilities.invokeLater(r);
    }
}