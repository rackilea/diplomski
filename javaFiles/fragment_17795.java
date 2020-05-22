class FastImageApiImpl implements ImageApi {
    @Override
    public Image create(int width, int height, Color c) {
       ... // faster windows specfic implementation
    }    
} 

public ImageApiFactory {
    public static ImageApi getImageApi() {
        if (isWindowsSystem()) {
            return new FastImageApiImpl();
        }
        return new ImageApiImpl();
    }
}