public class Rectangles 
{

private final double x;
private final double y;

private final double width;
private final double height;



public Rectangles(double x0, double y0, double w, double h)
{   
    x = x0;
    y = y0;
    width = w;
    height = h;

}
public double area()
{
    return width * height;
}
public double perimeter()
{
    return 2*width + 2*height;
}

public boolean intersects(Rectangles b)
{
    boolean leftof = ((b.x + (0.5*b.width))<(x-(0.5*width)));
    boolean rightof = ((b.x-(0.5*b.width))>(x+(0.5*width)));
    boolean above = ((b.y-(0.5*b.height))>(y+(0.5*height)));
    boolean below = ((b.y+(0.5*b.height))<(y-(0.5*height)));
    if (leftof==true || rightof==true || above==true || below==true)
        return false;
    else return true;

}

public void show()
{
    double j = Math.max((x+(0.5*height)), (y+(0.5*height)));
    StdDraw.setYscale((0),j+1);
    StdDraw.setXscale((0),j+1);
    StdDraw.setPenColor();
    StdDraw.rectangle(x,y,.5*width,.5*height);
}

public static void main(String[] args)
{
    Rectangles a = new Rectangles(Double.parseDouble(args[0]),
                                        Double.parseDouble(args[1]),
                                Double.parseDouble(args[2]),
                                Double.parseDouble(args[3]));
    Rectangles b = new Rectangles(2,2,2,2);
    System.out.println(a.area());
    System.out.println(a.perimeter());
    System.out.println(a.intersects(b));
    a.show();



 }

}