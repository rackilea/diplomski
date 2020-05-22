public interface ImageApi {
   Image create(int width, int height, Color c);
}

class ImageApiImpl implements ImageApi {
    @Override
    public Image create(int width, int height, Color c) {
       ... // implementation
    }    
} 

public ImageApiFactory {
    public static ImageApi getImageApi() {
        return new ImageApiImpl();
    }
}