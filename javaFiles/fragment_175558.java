package resources.images;

import java.net.URL;
import javax.swing.ImageIcon;

public class Resources {
    public static ImageIcon getImageIcon(String name) {
        URL imagePath = Resources.class.getResource(name);
        return new ImageIcon(imagePath);
    }
}