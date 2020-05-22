public class Test {

    public static void main(String[] args) {
        double d1 = 0xAAAAAAAAAAAAAAAAAAp0d;
        double d2 = 0x1.8p1d;

        System.out.println(d1); // A very big number
        System.out.println(d2); // 24 = 1.5 * 2^1
    }
}