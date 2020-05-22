import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
public class Member implements Serializable
{

    private String name;
    private byte[] imagebytes;

    public Member(String name, BufferedImage image) throws IOException
    {
        this.name = name;
        this.setImage(image);
    }

    public Member(String name, File imageFile) throws IOException
    {
        this.name = name;
        this.setImage(imageFile);
    }

    public final void setImage(BufferedImage image) throws IOException
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        this.imagebytes = outputStream.toByteArray();
    }

    public final void setImage(File imageFile) throws IOException
    {
        BufferedImage bufferedImage = ImageIO.read(imageFile);
        this.setImage(bufferedImage);
    }


    public BufferedImage getImage()
    {

        try
        {
            return ImageIO.read(new ByteArrayInputStream(imagebytes));
        } catch (Exception io)
        {
            return null;
        }
    }

    public String getName()
    {
        return name;
    }

}