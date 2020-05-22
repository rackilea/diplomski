public interface Summifier {

    public int getX();
    public int getY();

    // Note the default keyword
    default public int getXPlusY() { 
        return getX() + getY();
    }
}