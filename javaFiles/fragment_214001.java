public class Test {
    public static void main(String[] args) {
        I1 i1 = () -> System.out.println(); // NOT LEGAL
        I2 i2 = () -> System.out.println(); // TOTALLY LEGAL
        I3 i3 = () -> System.out.println(); // TOTALLY LEGAL
    }
}

interface I1 {
    void show1();
    void show2();
}

interface I2 {
    void show1();
    default void show2() {}
}

interface I3 {
    void show1();
    static void show2 () {}
}