public class Fibonacci {
private static final long MAX = 91;

public static long finonacciGetal(int n) {
        if (n > MAX || n < 0) throw new FibonacciException();
        else {

            long eerste = 0;
            long tweede = 1;
            long getal = 0;

            for (int i = 0; i < n; i++) {
                getal = eerste + tweede;
                eerste = tweede;
                tweede = getal;
            }
            return getal;
    }
}
}