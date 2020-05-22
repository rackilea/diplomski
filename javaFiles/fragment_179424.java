public class Camera {

    // both measures in meters
    public final double focalLength = 50e-3;
    public final double[] frame = {36e-3, 24e-3};

    public double[] position;
    // The rotation vector gives the unit vector directions, in the coordinate
    // frame of the object, of each of the axes of the camera's coordinate
    // frames
    public double[][] rotation;

    public Camera(double[] pos, double[][] rot) {

        position = pos;
        rotation = rot;
    }
}