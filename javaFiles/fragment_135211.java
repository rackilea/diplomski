import javax.imageio.ImageIO;

public class QuickTest {

    public static void main(String[] args) throws Exception {
        String[] types = ImageIO.getReaderFileSuffixes();
        System.out.println("This JRE supports image types:");
        for (String type : types) {
            System.out.println("Type: " + type);
        }
    }
}