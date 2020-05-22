import java.net.URL;
import javax.swing.*;

class ShowImage {

    public static void main(String[] args) throws Exception {
        final URL url = new URL("http://i.stack.imgur.com/1yeUy.png");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JLabel l = new JLabel(new ImageIcon(url));

                JOptionPane.showMessageDialog(null, l);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}