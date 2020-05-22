public class SameTypeCastsDemo {

    public static void withoutCasts() {
        int x = 2;
        int y = x;
        System.out.println(y);
    }

    public static void withCast() {
        int x = 2;
        int y = (int) x;
        System.out.println(y);
    }

}