public class Cube extends Box {

    public Cube(int length) {
        super(length, length, length);
    }

    public String toString() {
        return "Cube - " + getLength() + " X " + getWidth() + " X "
                + getHeight();
    }
}