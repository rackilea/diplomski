import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

    String text = "" + i;
    File imageFile = new File(listOfFiles[i].getAbsolutePath());
    BufferedImage image = ImageIO.read(imageFile);
    Image scaledImage = image.getScaledInstance(139, 163, 
            BufferedImage.SCALE_SMOOTH);
    ImageIcon imageIcon = new ImageIcon(scaledImage);
    toglBtn = new JToggleButton(text, imageIcon);