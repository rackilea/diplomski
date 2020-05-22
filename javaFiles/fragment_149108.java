import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BrowserPannel {

    public static void main(String[] arg) {
        JFrame browser = new JFrame("A Nun In A Weelchair");
        browser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        browser.setLocationRelativeTo(null);

        JTextField url = new JTextField(20);

        JPanel header = new JPanel();
        header.setBackground(Color.lightGray);

        JButton send = new JButton("Send");

        JEditorPane htmlc = new JEditorPane();
        htmlc.setBackground(Color.red);
        htmlc.setEditable(true);
        htmlc.setContentType("text/html");

        header.add(url);
        header.add(send);
        browser.getContentPane().add(header, BorderLayout.NORTH);
        browser.getContentPane().add(new JScrollPane(htmlc));

        browser.pack();
        browser.setVisible(true);

    }
}