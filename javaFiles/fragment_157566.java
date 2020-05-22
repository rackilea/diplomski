public class Circle implements Shapes{
    private int radius;

    public Circle (int radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return (radius * radius) * Math.PI;
    }

    @Override
    public double calculatePrimeter() {
        return (radius * 2) * Math.PI;
    }
}

public class Rectangle implements Shapes{}
public class Square implements Shapes{}