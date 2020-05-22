public class Constants {

    public static final float PPM = 32; // PPM = Pixel per Meter
    public static final float MPP = 1 / PPM; // MPP = Meter per Pixel

    public static final int WORLD_PIXEL_WIDTH = 512;
    public static final int WORLD_PIXEL_HEIGHT = 256;
    public static final float WORLD_WIDTH = WORLD_PIXEL_WIDTH / PPM; //in meter
    public static final float WORLD_HEIGHT = WORLD_PIXEL_HEIGHT / PPM; //in meter
}