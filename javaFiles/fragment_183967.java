public class Coord3D extends myCoord {
    private double coorZ;

    Coord3D() {
        super(); // not super.myCoord(); its a constructor call not method call
        coorZ = 1;
    }

    Coord3D(double x, double y, double z) {
        super(x,y);  // not super.myCoord(x,y); its a constructor call not method call
        coorZ = z;
    }
}