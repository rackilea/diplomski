import javax.swing.*;
import java.net.URL;

class ShowAnimatedGif {

    public static void main(String[] args) throws Exception {
        final URL url = new URL("http://pscode.org/media/starzoom-thumb.gif");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JLabel l = new JLabel(new ImageIcon(url));
                JOptionPane.showMessageDialog(null, l);
            }
        });
    }
}