public interface Shape {
    double area();
    double perimeter();
}

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    public double area() { return w*h; }
    public double perimeter() { return 2.0*(w+h); }
}

public class ShapeFactory() { 
    public Shape createShape(double ... args) {
        if (args.length == 1) {
            return new Circle(args[0]);
        } else if (args.length == 2) { 
            return new Rectangle(args[0], args[1]);
        } else {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
    }
}