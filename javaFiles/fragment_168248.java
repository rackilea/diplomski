import java.awt.*;
import javax.swing.*;

class SwingHTMLBorder {

    static String html = "<html>" +
        "<head>" +
        "<style type='text/css'>" +
        "p {" +
        "   border: solid 1px red;" +
        "}" +
        "</style>" +
        "</head>" +
        "<body>" +
        "<p>Do you see a border?</p>" +
        "<table border=1>" +
        "<tr>" +
        "<td>Cell 1</td>" +
        "<td>Cell 2</td>" +
        "</tr>" +
        "</table>";

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, new JLabel(html));
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}