package test

import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class HtmlDemo extends JPanel {

    public HtmlDemo() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        String rgb = Integer.toHexString(SystemColor.window.getRGB());
        String backgroundColor = rgb.substring(2, rgb.length());

        String html = "<html>\n"
            + "<head>\n"
            + "<style type=\"text/css\">\n"
            + "table {\n" + "width: 100%\n" + "}\n"
            + "td, th {\n" + "background-color: #" + backgroundColor + "\n"
            + "}\n"
            + "</style>\n"
            + "</head>\n"
            + "<body>\n"
            + "HTML table test:\n"
            + "<div style=\"background-color: black\">\n"
            + "<table border=\"0\" cellpadding=\"2\" cellspacing=\"1\">\n"
            + "<tr>\n" + "<td>\n" + "cell1\n" + "</td>\n" + "<td>\n" + "cell2\n" + "</td>\n" + "</tr>\n"
            + "<tr>\n" + "<td>\n" + "cell3\n" + "</td>\n" + "<td>\n" + "cell4\n" + "</td>\n" + "</tr>\n"
            + "</div>\n"
            + "</body>\n"
            + "</html>";

        JLabel label = new JLabel(html);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(label);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame("HtmlDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new HtmlDemo());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}