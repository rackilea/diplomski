import javax.swing.*;

public class CustomFontForBoldAndItalic {

    public static String EOL = System.getProperty("line.separator");
    private static String styles = 
            "p {font-family: serif; font-size: 25px;}" + EOL
            + "b {font-family: sans-serif;}" + EOL
            + "em {font-family: monospaced;}" + EOL
            ;
    private static String html = "<html><head><title>HaHa</title><style type='text/css'>" 
            + EOL
            + styles + "</style></head><body>"
            + "<p>This part is <b>bold</b> while this part is <em>italic</em>.</p>"
            + "</body></html>";

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, new JLabel(html));
            }
        };
        SwingUtilities.invokeLater(r);
    }
}