public class SpecialImage {

  // The thing isn't a manipulator, it's a BufferedImage
  // I would suggest renaming this for ease of maintenance
  BufferedImage manipulator;

  public SpecialImage(String path) {
    manpiulator = ImageIO.read(new File(path));
  }

}