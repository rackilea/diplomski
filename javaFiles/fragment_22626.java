public abstract class SuperClass{

    protected final int x, y, halfX, halfY;

    public SuperClass(int x, int y){
        this.x = x; // set x before using it.
        this.y = y; // set y before using it.
        halfX = x / 2;
        halfY = y / 2;
    }
}

public abstract class SubClass extends SuperClass{

    private final int z;

    public SubClass(int x, int y, int z){
        super(x, y);
        // only set fields of SubClass
        this.z = z;
    }