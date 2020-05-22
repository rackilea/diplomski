public class Coord {

    public final int r;
    public final int c;

    public Coord(int r, int c) {
        this.r = r;
        this.c = c;
    }

    //copy constructor
    public Coord(Coord other) {
        this(other.r, other.c);
    }

}