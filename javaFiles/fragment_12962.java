public class Square extends RegularPolygon{
    public Square(double length)
    {
        super(length);
    }
    public double getArea()
    {
        // use 'this.getSide()' to retrieve the value in 'side'
        return this.getSide()*this.getSide();
    }  
}