public class color1
{
    public color1()
    {
    }

    public int[] getCol(int xIn, int yIn)
    {
        // accepts position of color, returns size 3 array of red green blue
        // integers
        int[] color = new int[3]; // Has to be here because of how you're (not) handling exceptions
        try
        {
            Robot r = new Robot();
            Color x = r.getPixelColor(xIn, yIn);
            color[0] = x.getRed();
            color[1] = x.getGreen();
            color[2] = x.getBlue();
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }
        return color;
    }
}