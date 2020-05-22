public class Polygon  extends Shape {    
    private int noSides;
    private int lenghts[];

    public Polygon(int id,Point center,int noSides,int lengths[]) {
        super(id, center);
        this.noSides = noSides;
        this.lenghts = lengths;
    }
}

public class RegularPolygon extends Polygon {
    private static int[] getFilledArray(int noSides, int length) {
        int[] a = new int[noSides];
        java.util.Arrays.fill(a, length);
        return a;
    }

    public RegularPolygon(int id, Point center, int noSides, int length) {
        super(id, center, noSides, getFilledArray(noSides, length));
    }
}