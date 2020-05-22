public class Rectangle {
    private double width;
    private double length;

    public boolean setWidth(double width) {
        if(width >= 0.0 && width < 20.0) {
            this.width = width; // <<< You need this line ...
            return true;
        } else return false;
    }

    public boolean setLength(double length) {
        if(length >= 0.0 && length < 20.0) {
            this.length = length; // <<< ... and this one, too!
            return true;
        } else return false;
    }
}