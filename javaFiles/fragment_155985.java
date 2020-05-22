public abstract class SuperClass {
    // Variable all inner classes must set
    static int myVar = 0;

    public SuperClass() {
        myVar = giveValue();
    }

    public abstract int giveValue();
}