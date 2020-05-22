public class Box extends Rectangle {

    private final int height;

    public Box(int length, int width, int height) {
        super(length, width);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return "Box - " + getLength() + " X " + getWidth() + " X " + height;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (height * 343);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Box)) {
            return false;
        }
        Box that = (Box) obj;
        return this.hashCode() == that.hashCode();
    }
}