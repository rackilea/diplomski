class StaticDemo {
    public static int stvar;

    public static void square(int s) {
    //     ^^^^^^                 ^
        System.out.println("" + s * s);
    //                          ^   ^
    }
}

public class StaticTest {
    public static void main(String args[]) {
        StaticDemo.square(StaticDemo.stvar);
    //  ^^^^^^^^^^^       ^^^^^^^^^^^^^^^^
    }
}