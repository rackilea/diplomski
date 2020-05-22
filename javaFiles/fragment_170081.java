import java.awt.*;
import javax.swing.*;
import java.net.URL;

class DisplayFont {
    public static void main(String[] args) throws Exception {
        URL fontUrl = new URL("http://www.webpagepublicity.com/" +
            "free-fonts/a/Airacobra%20Condensed.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        font = font.deriveFont(Font.PLAIN,20);
        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        JLabel l = new JLabel(
            "The quick brown fox jumps over the lazy dog. 0123456789");
        l.setFont(font);
        JOptionPane.showMessageDialog(null, l);
    }
}