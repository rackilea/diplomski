public class Sphere {
    public double diameter;

    public Sphere(double diameter) {
        this.diameter = diameter;
    }

    public double volume() {
        return (4.0 / 3.0) * (Math.PI) * Math.pow((diameter / 2.0), 3);
    }

    public double surfaceArea() {
        return (4) * (Math.PI) * (Math.pow((diameter / 2.0), 2));
    }

    public String toString()
    {
       return "The diameter of this sphere is " + diameter + ", the volume is " + volume() + ", and the surface area is " + surfaceArea() + ". ";
    }
}