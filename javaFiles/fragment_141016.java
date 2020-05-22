public class Circle implements Comparable<Circle> {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // you MUST override the compareTo method from the Comparable interface
    @Override
    public int compareTo(Circle cirlce){
        if (this.getArea() > circle.getArea())
            return 1;
        else if (this.getArea() == circle.getArea())
            return 0;
        else 
            return -1;
    }

    public double getArea(){
        return radius * radius * Math.PI;
    }
}