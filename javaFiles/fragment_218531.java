import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;

class SomeClass{

    ImageIcon imgOne = new ImageIcon(new BufferedImage(images.get(imgPath)))
    ImageIcon imgTwo = new ImageIcon(new BufferedImage(images.get(imgPathTwo)))
    private ArrayList<ImageIcon> imagesHolder = new ArrayList<ImageIcon>(){{
        add(imgOne);
        add(imgTwo);
    }};

    public ImageIcon getImageIcon(int index){
        return imagesHolder.get(index);
    }
}

class test{
    SomeClass imageHolder = new SomeClass();

    JLabel label = new JLabel(imageHolder.getImageIcon(0));
    JFrame f = new JFrame();
    f.getContentPane().add(label);
}