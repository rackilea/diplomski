// Imports required
import java.util.Base64
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.imageio.ImageIO;

String imageData = "data:image/png;base64,iVBORw0KGgoAAAANSUhE....";
String base64Data = imageData.split(",")[1]

byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
BufferedImage image = ImageIO.read(bis);

File outputFile = new File("output.png");
ImageIO.write(image, "png", outputFile);