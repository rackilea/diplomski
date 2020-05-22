// expected params are width and height
public void setDimension(double... dim) {
    if (dim.length != 2) {
        throw new IllegalArgumentException("Two dimensions expected, width ang height!");
    }
    ...
}