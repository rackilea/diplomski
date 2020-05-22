public abstract class BasePlugin {
    private int x; //Mysterious x
    public BasePlugin() {
        x = 42;
    }
    public abstract void update(); //update func that may need x, but can't change it
    protected final int getX() {return x;} //x accessor
}