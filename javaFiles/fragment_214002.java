public class Test {
    public static void main(String[] args) {
        I1 i1 = () -> System.out.println(); // NOT LEGAL BUT WE SAW IT EARLIER
        I2 i2 = () -> System.out.println(); // NOT LEGAL
    }
}

interface I1 {
    void show1();
    void show2();
}

interface I2 extends I1 {
    void show3();
}