public interface ProductTrader<P, S> {

  public P create(S specification);

}

public interface ImageCreator {

  public boolean canProcess(File file);

  public Image createImage(File file);

}

public class PNGImageCreator implements ImageCreator {

  public boolean canProcess(File file) {
    return (file.isFile() && file.canRead() && file.getName().endsWith(".png"));
  }

  public Image createImag(File file) {
    //Image I/O code goes here
  }

}

public class FileToImageProductTrader implements ProductTrader<Image, File> {

  private List<ImageCreator> imageCreators = new ArrayList<ImageCreator>();

  public void registerCreator(ImageCreator creator) {
    imageCreators.add(creator);
  }

  public Image create(File specification) {
    for(ImageCreator creator : imageCreators) {
      if(creator.canProcess(specification)) {
        return creator.createImage(specification);
      }
    }
    //No creator for given file
    return null;
  }

}

public class Main {

  public static void main(String [] args) {
    FileToImageProductTrader trader = new FileToImageProductTrader();
    PNGCreator pngCreator = new PNGCreator();
    trader.registerCreator(pngCreator);
    File imageFile = new File("/tmp/foo.png");
    Image image = trader.create(imageFile);
  }

}