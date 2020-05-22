public class OriginConstants {
      // static final fields allows to access constants via class accessor i. e. OriginConstants.x (no need to create instance)
      public static final int x = 0;
      public static final int y = 0;
}

public class ImmutablePoint {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MutablePoint {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}