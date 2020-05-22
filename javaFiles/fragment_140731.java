import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

public Main{
    public static void main(String args[]){
        try {
            BufferedImage bimg = ImageIO.read(new URL("https://pictures.dealer.com/w/woodhouseomahaincfordfd/0027/a958ba95df26eaf392e298293da2847ex.jpg"));
            System.out.println(bimg.getWidth()+"==="+bimg.getHeight());
            bimg = ImageIO.read(new URL("https://pictures.dealer.com/ddc/resize/240x/quality/70/sharpen/1/ddc/w/woodhouseomahaincfordfd/0027/a958ba95df26eaf392e298293da2847ex.jpg"));
            System.out.println(bimg.getWidth()+"==="+bimg.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}