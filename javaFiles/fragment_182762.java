import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

public class test {
    public static void main(String[] arg)throws Exception
    {
        BufferedImage imgIn = ImageIO.read(new File("/home/arpit/Desktop/image.jpg"));
        BufferedImage imgIn2 =  new BufferedImage(imgIn.getHeight(), imgIn.getWidth(), imgIn.getType());

        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.PI / 2, imgIn2.getWidth() / 2, imgIn.getHeight() / 2);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        op.filter(imgIn, imgIn2);

        ImageIO.write(imgIn2, "JPEG", new File("/home/arpit/Desktop/testrotated.jpg"));
    }
}