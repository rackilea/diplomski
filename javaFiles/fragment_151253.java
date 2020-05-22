/* Invalid radius class that contains error code */
public class InvalidRadiusException extends Exception {
     private double radius;

/** Construct an exception */
public InvalidRadiusException(double radius) {
       super("Invalid radius " + radius);
       this.radius = radius;
}

/** Return the radius */
public double getRadius() {
    return radius;
 }
}