import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageScan {

    private List<Image> images = new ArrayList<Image>();

    public void loadImages() {

        List<Image> imageArray = new ArrayList<Image>();

        File file = new File("data/images");

        File[] imageFiles = file.listFiles(); // This gets all of the files inside 
'file', if 'file' is a folder
        for (File f : imageFiles) {
            try {
                BufferedImage image = ImageIO.read(f);
                imageArray.add(image);
            } catch (Exception e) {
                // This makes sure only the images in the folder are used, not any 
file.
            }
        }

        this.setImages(imageArray);
    }

    public void setImages(List<Image> imageArray) {
        images = imageArray;
    }

    public List<Image> getImages() {
        return images;
    }

}