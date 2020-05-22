public class PointName extends java.awt.Point
{

    private String name;

    public PointName(String name, int x, int y)
    {
        super(x,y);
        this.name = name;
    }

    public String toString()
    {
        return this.name + " : " + super.toString(); 
    }
}