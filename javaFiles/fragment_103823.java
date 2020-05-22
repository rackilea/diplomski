import javax.swing.*;
import java.awt.GridLayout;

class ThumbTip {

    private static final String HTML = "<html><body>";

    ThumbTip(String[] album) {
        JPanel p = new JPanel(new GridLayout(1,0,2,2));
        for (String url : album) {
            String s = HTML + "<img src='" + url.toString() + "'";
            String size = " width=200 height=150";
            JLabel l = new JLabel(s + size + ">");
            l.setToolTipText(s + ">");
            p.add(l);
        }
        JOptionPane.showMessageDialog(null, p);
    }

    public static void main(String[] args) {
        final String[] urls = {
            "http://pscode.org/media/stromlo1.jpg",
            "http://pscode.org/media/stromlo2.jpg"
        };
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ThumbTip(urls);
            }
        });
    }
}