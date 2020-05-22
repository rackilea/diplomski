import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Heightmap {


public static int width = 200;
public static int height = 200;

public static void main(String[] args) {

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB );
    for(int x = 0; x < width; x++){
        for(int y = 0; y < height; y++){
            int randomValue = (int)(Math.random() * 256);
            Color randomColor = new Color( randomValue, randomValue, randomValue);

            bufferedImage.setRGB(x, y, randomColor.getRGB());
        }
    }

    File outputFile = new File("heightmap.png");
    try { 
        ImageIO.write(bufferedImage, "png", outputFile);
    }catch (IOException ioex){
        ioex.printStackTrace();
    }




}