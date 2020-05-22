public class Cube extends PrismSet implements ShapeFunctions {

    public double surfaceArea() {
        double cubeSurfaceArea = super.findFrontBackFaceArea(super.prismHeight, super.prismWidth) * 3;
        return cubeSurfaceArea;
    }

    public double volume() {
        double cubeVolume = Math.pow(super.prismWidth, 3);
        return cubeVolume;
    }

}