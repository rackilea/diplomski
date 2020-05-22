-(ey - ay), ex - ax

public Vector calculateReflection( Vector velocity){
    double velocityDotProduct = Vector.dotProduct(normal, velocity);
    Vector reflectionVelocity = 
       new Vector(velocity.getX() + 2*velocityDotProduct*normal.getX(),
       velocity.getY() + 2*velocityDotProduct*normal.getY());
    return reflectionVelocity;
}
public void normalize(){
    double d = Math.sqrt( x*x + y*y );
    x /= d;
    y /= d;
}

public static double dotProduct(Vector v1, Vector v2){
    double res = v1.getX()*v2.getX() + v1.getY()*v2.getY();
}

public class Reflect {
private Vector normal;

public Reflect(double begX, double begY, double endX, double endY ){
    normal = new Vector(-(endY - begY), endX - begX);
    normal.normalize();
    System.out.println( "normal: " + normal );
}

public Vector calculateReflection( Vector velocity){
     double velocityDotProduct = Vector.dotProduct(normal, velocity);
     Vector reflectionVelocity = 
       new Vector(velocity.getX() - 2*velocityDotProduct*normal.getX(),
           velocity.getY() - 2*velocityDotProduct*normal.getY());
     return reflectionVelocity;
}