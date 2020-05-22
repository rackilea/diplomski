public abstract class Shapes
{
    protected final double pi=3.14;

    //varible pi is delcared as constant

     protected double radius;
     protected double height;

     public Shapes (double gRadius,double gHeight)  
     {
        //sets radius, height variables to parameter values
        radius=gRadius;
        height=gHeight;
     }

     abstract public double getCircumference();
     abstract public double getTotalSurfaceArea();
     abstract public double getVolume();

     public static void main(String[] args)
     {
     }
}