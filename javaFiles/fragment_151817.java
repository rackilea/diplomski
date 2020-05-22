public interface Shape {
    public double volume();

    public double surfaceArea();
}

public class Tetrahedron implements Shape{
    double edge;
    Tetrahedron(double edge) {
        this.edge=edge;
    }

    @Override
    public double volume(){
         return Math.pow(edge, 3)/(6*Math.sqrt(2));
    }

    @Override
    public double surfaceArea(){
         return Math.sqrt(3)*Math.pow(edge, 2);
    }
}