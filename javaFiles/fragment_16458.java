public class SameTypeCastsDemo {
    Integer x;
    Integer y;

    public SameTypeCastsDemo(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println(y);
    }

    public static void withoutCasts() {
        SameTypeCastsDemo x = new SameTypeCastsDemo(2, 3);
        SameTypeCastsDemo y = x;
        y.print();
    }

    public static void withCast() {
        SameTypeCastsDemo x = new SameTypeCastsDemo(2, 3);
        SameTypeCastsDemo y = (SameTypeCastsDemo) x;
        y.print();
    }

}