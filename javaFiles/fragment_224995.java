public class Particle{
    private double mass;
    private PhysicsVector initialPosition = new PhysicsVector();
    private PhysicsVector initialVelocity = new PhysicsVector();

    public Particle(){
        mass = 1;
        initialPosition.setVector(0,0);
        initialVelocity.setVector(1,1);
    }

    public Particle(double mass, PhysicsVector a, PhysicsVector b, double timeStep, PhysicsVector aDueToGravity){
        initialPosition = a;
        initialVelocity = b;

        PhysicsVector v = new PhysicsVector();
        v = initialVelocity;
        v = v.scale(timeStep, initialVelocity);     //v = initialVelocity *t

        PhysicsVector a = new PhysicsVector();
        a = a.scale(timeStep, aDueToGravity);       //a = aDueToGravity*t

        initialPosition.increaseBy(v);          //initialPosition = initialPosition + v
        initialVelocity.increaseBy(a);          //initialVelocity = initialVelocity + a

        initialPosition.print();
        initialVelocity.print();
    }

    public double positionY(){
        return initialPosition.getY();  //get y component with method in PhysicsVector
    }

    public PhysicsVector getNewVelocity(){
        return initialVelocity;
    }

    public PhysicsVector getNewPosition(){
        return initialPosition;
    }
}