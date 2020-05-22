public class PrismSet extends Prisms {

    public double surfaceAreaHolder;
    public double volumeHolder;

    public void setCubeLength(ShapeDriver sDriver) {
        super.prismHeight = sDriver.cubeSide;
        super.prismWidth = sDriver.cubeSide;
    }

    public double surfaceArea() {
        return surfaceAreaHolder;
    }

    public double volume() {
        return volumeHolder;
    }

}