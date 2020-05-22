public class Subclass extends Superclass {
    public void setX(int x) { 
        if(x >= 0) throw new IllegalArgumentException("X must be negative");
        super.setX(x); 
    }
}