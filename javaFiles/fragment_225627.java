public class MyBi extends BufferedImage
{
    private final BufferedImage realBufferedImage;

    public MyBi(BufferedImage bi)
    {
        super(0, 0, TYPE_INT_ARGB);
        realBufferedImage = bi;
    }

    // Add methods for managing your extra data

    // For every method in BufferedImage, override it like so:
    public void setData(Raster r)
    {
        realBufferedImage.setData(r);
    }
}