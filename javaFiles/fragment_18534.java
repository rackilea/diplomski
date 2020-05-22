public abstract class Shape {
    public abstract boolean collidesWith (Shape s);
}

public class Ball extends Shape {
    @Override public boolean collidesWith (Shape s) {
        if (s instanceof Block)
            return collidesWithBlock((Block)s);
        else if (s instanceof Ball)
            return collidesWithBall((Ball)s);
        else
            return false;
    }
    public boolean collidesWithBall (Ball b) {
        ... 
    }
    public boolean collidesWithBlock (Block b) {
        ...
    }
}

public class Block extends Shape {
    @Override public boolean collidesWith (Shape s) {
        if (s instanceof Block)
            return collidesWithBlock((Block)s);
        else if (s instanceof Ball)
            return ((Ball)s).collidesWithBlock(this);
        else
            return false;
    }
    public boolean collidesWithBlock (Block b) { 
        ...
    }
}