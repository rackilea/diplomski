public class ScreenType implements Comparable {
    int width;
    int height;
    int color; // not sure what this one was for, assuming 32/16 bit color
    int hertz;

    public ScreenType(int w, int h, int c, int h) {
        width = w;
        height = h;
        color = t;
        hertz = h;
    }

    // remember to maintain transitive property,
    // see JDK documentation for Comparable
    @Override
    public int compareTo(Tuple other) {
    }

    // getters and setters and whatnot

    @Override
    public String toString() {
        return width + "X" + height + "X" + color+ "    " + hertz + "hz";
    }
}