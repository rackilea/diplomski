import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PhotoTest {
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;

    public static void main(String[] args) throws IOException {
        JFrame f = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setBounds(dim.width/2-FRAME_WIDTH/2, dim.height/2-FRAME_HEIGHT/2, FRAME_WIDTH, FRAME_HEIGHT);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        URL url = new URL("http://www.archisevilla.org/wp-content/themes/archisevilla/images/loading.gif");
        //URL url = Photo.class.getResource("a.jpg"); // Use this if your image is near your 
        ImageIcon image = new ImageIcon(url);
        Photo photo = new Photo("Title", image, "Sample of a photo component!");
        f.add(photo);
        //
        f.setVisible(true);
    }
}