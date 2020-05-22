public class Main {
    public static void main(String[] args) {
        long x = 0xB3E110C4CFF34548L;

        System.out.printf("%16X %20d\n", x, x);
        System.out.printf("%16X %20d\n", x % 5, x % 5);
        System.out.printf(
            "%16X %20d\n", Math.floorMod(x, 5), Math.floorMod(x, 5)
            );
        System.out.printf("%16X %20d\n", Long.remainderUnsigned(x, 5), Long.remainderUnsigned(x, 5));
    }
}