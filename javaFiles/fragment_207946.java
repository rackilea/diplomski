public abstract class Geometry 
{
    private String shapeId;
    private ColorValue colorValue;

    public Shape(String shapeId, int red, int green, int blue)
    {
        this.shapeId = shapeId;
        setColorValue(red, green, blue);
    }

    public ColorValue getColorValue()
    {
        return colorValue;
    }

    // Note the consistent order of the parameters - always red, green, blue.
    public void setColorValue(int red, int green, blue)
    {
        // Don't use System.exit() in the middle of a method! An exception
        // is the idiomatic way of reporting bad arguments.
        if (red == 0 || blue == 0 || green == 0)
        {
            throw new IllegalArgumentException("red green and blue must be non-zero");
        }
        colorValue = new ColorValue(red, green, blue);
    }
}