public interface ImageDataProvider {
  public ImageData getImageData (int zoom);
}
public interface ImageFileNameProvider {
  public String getImagePath (int zoom);
}