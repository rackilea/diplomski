public class ComparableColor implements Comparable<ComparableColor> 
{
    Color color;
    public ComparableColor(Color color)
    {
        this.color = color;
    }
    @Override
    public int compareTo(ComparableColor c) 
    {
        return c.color.getAlpha() - this.color.getAlpha();

    }

}