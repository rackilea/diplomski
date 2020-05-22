public class Rectangle {

    private final int length;
    private final int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String toString() {
        return "Rectangle - " + length + " X " + width;
    }

    @Override
    public int hashCode() {
        return (length * 159) + (width * 523);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle that = (Rectangle) obj;
        return this.hashCode() == that.hashCode();
    }

}