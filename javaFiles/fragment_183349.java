import java.awt.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class ChangeImageOnClick {

    public static void main(String[] args) throws Exception {
        URL url1 = new URL("http://i.stack.imgur.com/gJmeJ.png");
        final Image img1 = ImageIO.read(url1);
        URL url2 = new URL("http://i.stack.imgur.com/wCF8S.png");
        final Image img2 = ImageIO.read(url2);
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JToggleButton btn = new JToggleButton("Click me!");
                btn.setIcon(new ImageIcon(img1));
                btn.setSelectedIcon(new ImageIcon(img2));

                btn.setContentAreaFilled(false);
                btn.setBorderPainted(false);

                JOptionPane.showMessageDialog(null, btn);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}