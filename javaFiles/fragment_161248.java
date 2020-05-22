public class DisplayedObject
{
    public BufferedImage IMAGE;
    ...
    public DisplayedObject(String filename) {
        InputStream is = getClass().getResourceAsStream(filename);
        try {
            IMAGE = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Can't read image.");
        }
    }
}