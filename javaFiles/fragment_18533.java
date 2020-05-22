public abstract class Shape {
    public abstract boolean collidesWith (Shape s);
}

public class Ball extends Shape {
    @Override public boolean collidesWith (Shape s) {
        if (s instanceof Block)
            return Collision.blockBall((Block)s, this);
        else if (s instanceof Ball)
            return Collision.ballBall(this, (Ball)s);
        else
            return false;
    }
}

public class Block extends Shape {
    @Override public boolean collidesWith (Shape s) {
        if (s instanceof Block)
            return Collision.blockBlock(this, (Block)s);
        else if (s instanceof Ball)
            return Collision.blockBall(this, (Ball)s);
        else
            return false;
    }
}

public class Collision {
    public static boolean blockBlock (Block a, Block b) { ... }
    public static boolean blockBall (Block a, Ball b) { ... }
    public static boolean ballBall (Ball a, Ball b) { ... }
}