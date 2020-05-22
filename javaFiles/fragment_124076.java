public class TestIt {
public static void main(String[] args) throws IOException {

Image img = null;
img = ImageIO.read(TestIt.class.getResourceAsStream( "i.png" ));
img.getGraphics();
System.out.println(img);
}