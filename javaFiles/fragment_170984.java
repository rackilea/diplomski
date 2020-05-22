public class collatzpow {

public static int count = 0;
public static PrintStream StdOut = System.out;

public static int collatz(int n) {
    ++count;
    StdOut.print(n + " ");
    if (n == 1) return 0;
    if (n % 2 == 0) return collatz(n / 2);
    else return collatz(3 * n + 1);

}

public static void main(String[] args) {

    int n = Integer.parseInt(args[0]);
    StdOut.println(collatz(7));
    System.out.println(count);
}
  }