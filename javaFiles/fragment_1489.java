import java.net.*;
import javax.swing.*;

public class UIForIshidaQuery {

    public static String url = "http://i.stack.imgur.com/gJmeJ.png";

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Running...");

        JFrame window1 = new JFrame();
        window1.setSize(1080, 720);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = (JPanel) window1.getContentPane();
        JLabel label1 = new JLabel();
        //panel1.setLayout(null);
        ImageIcon image = new ImageIcon(new URL(url));
        label1.setIcon(image);
        //label1.setBounds(500, 500, 500, 500);
        panel1.add(label1);
        window1.setVisible(true);
    }
}