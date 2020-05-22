public class Geom implements GeomInterface {
    private double dx;
    private double dy;
    private double dz;
    private String color;

    public Geom() {
        this.dx = 0;
        this.dy = 0;
        this.dz = 0;
        this.color = "Black";
    }

    public Geom(double dx, double dy, double dz, String color) {
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
        this.color = color;
    }

    @Override
    public void move(double dx, double dy, double dz) {
        // Implement logic here

        // Sample
        this.dx = dx;
    }

    @Override
    public double getVolume() {
        double volume = 0;

        // Implement logic here

        // Sample
        volume = this.dx * this.dy * this.dz;

        return volume;
    }

    @Override
    public double getArea() {
        double area = 0;

        // Implement logic here 

        // Sample
        area = this.dx * this.dy;

        return area;
    }

    @Override
    public double getDistanceTo(Geom other) {
        double distance = 0;

        // Implement logic here

        // Sample
        distance = this.dx - other.dx; 

        return distance;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getDz() {
        return dz;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public void setDz(double dz) {
        this.dz = dz;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}