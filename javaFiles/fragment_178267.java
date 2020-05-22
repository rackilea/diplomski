class StaticDemo {
    public static int stvar;

    public void square(int s) {
    //                     ^
        System.out.println("" + s * s);
    //                          ^   ^
    }
}

public class StaticTest {
    public static void main(String args[]) {
        new StaticDemo().square(StaticDemo.stvar);
    //  ^^^^^^^^^^^^^^^^        ^^^^^^^^^^^^^^^^
    }
}