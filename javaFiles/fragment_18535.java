public abstract class CollisionAlgorithm {
    public abstract boolean canCollide (Class<? extends Shape> a, Class<? extends Shape> b);
    public abstract boolean collide (Shape a, Shape b);
}

public class Collider {

    private static final List<CollisionAlgorithm> algorithms;

    public static void registerAlgorithm (CollisionAlgorithm a) { 
        algorithms.append(a); 
    }

    public static CollisionAlgorithm findAlgorithm (Class<? extends Shape> a, Class<? extends Shape> b) {
        for (CollisionAlgorithm algo : algorithms)
            if (algo.canCollide(a, b))
                return algo; 
        return null;
    }

    public static boolean collide (Shape a, Shape b) {
        if (a == null || b == null) 
            return false;
        CollisionAlgorithm algo = findAlgorithm(a.getClass(), b.getClass());
        if (algo != null)
            return algo.collide(a, b);
        algo = findAlgorithm(b.getClass(), a.getClass()); // try swapped order
        if (algo != null)
            return algo.collide(b, a);
        return false;
    }

}

// usage: first register algorithms
Collider.registerAlgorithm(new BallBallAlgorithm());
Collider.registerAlgorithm(new BallBlockAlgorithm());
Collider.registerAlgorithm(new BlockBlockAlgorithm());

// then 
Shape myShape1 = ...;
Shape myShape2 = ...;
boolean collide = Collider.collide(myShape1, myShape2);