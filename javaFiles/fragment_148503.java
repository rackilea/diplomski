public class DeepBufferedImage extends BufferedImage {
    private final float[] zIndex;

    public DeepImage(final BufferedImage image, final float[] zIndex) {
        super(image.getColorModel(), image.getRaster(), image.getColorModel().isAlphaPremultiplied(), null);
        if (zIndex.length != image.getWidth() * image.getHeight()) {
            throw new IllegalArgumentException("bad zIndex length");
        }
        this.zIndex = zIndex; // Obviously not safe, but we'll go for performance here
    }

    public float getZ(int x, int y) {...}; 
    public void setZ(int x, int y, float z) {...}; 

    public float[] getZ(int x, int y, int w, int h) {...}; 
    public void setZ(int x, int y, int w, int h, float[] z) {...}; 

}