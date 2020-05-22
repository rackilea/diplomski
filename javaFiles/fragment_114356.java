public class Frame {

static {
    System.loadLibrary( "gtengine" );
}

public static native Pointer FrameCstructor(String name, long parent,
        double x, double y, double z,
        double rotX, double rotY, double rotZ,
        double vX, double vY, double vZ,
        double angVx, double angVy, double angVz,
        double accX, double accY, double accZ,
        double angAccX, double angAccY, double angAccZ,
        boolean addToFramelist);

private Pointer ptrToCFrame;

public Frame(String name, int parent,
        double x, double y, double z,
        double rotX, double rotY, double rotZ,
        double vX, double vY, double vZ,
        double angVx, double angVy, double angVz,
        double accX, double accY, double accZ,
        double angAccX, double angAccY, double angAccZ,
        boolean addToFramelist) {

    System.out.println("library: " + System.getProperty( "java.library.path" ));

    ptrToCFrame = FrameCstructor( name, parent,
            x, y, z, rotX, rotY, rotZ,
            vX, vY, vZ, angVx, angVy, angVz,
            accX, accY, accZ, angAccX, angAccY, angAccZ,
            addToFramelist );
    }
}