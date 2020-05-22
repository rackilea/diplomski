public abstract class Fish {

    // rest of class omitted

    @Override
    public String toString() {
        return "A " + size + "cm, " + weight + "kg " + getClass().getSimpleName();
    }
}