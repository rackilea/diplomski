public class MyCustomBorder extends AbstractBorder
{
    private Color borderColour;
    private int borderThickness = 10;
    private Point firstSlider = new Point(0, 0);
    private Point secondSlider = new Point(0, 0);
    private BufferedImage firstSliderImage;
    private BufferedImage secondSliderImage;

    Boolean draggingFirst = false;
    Boolean draggingSecond = false;

    //See usage info
    public MyCustomBorder(Color colour, int thickness, Point firstSlider, BufferedImage firstSliderImage, Point secondSlider, BufferedImage secondSliderImage)
    {
        borderColour = colour;
        borderThickness = thickness;
        this.firstSlider = firstSlider;
        this.secondSlider = secondSlider;
        this.firstSliderImage = firstSliderImage;
        this.secondSliderImage = secondSliderImage;
    }