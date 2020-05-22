/**
 * Print string form of `o`, but indented with n spaces
 */
private static void printIndented(int n, Object o) {
    while (n-->0) System.out.print("  ");
    System.out.println(o);
}

/* 
 * Added a third param `d` to keep track of the depth of the recursion
 */
public static double power1(double a, int n, int d) {
    // Entering a "possible" recursive call
    printIndented(d, "call power1, a=" + a + ", n=" + n + ", d=" + d);

    double result;
    if(n == 0) {
        // Returning from the base case, this should have the largest depth.
        printIndented(d, "return 1.0");

        return 1;
    }
    else {
        result = power1(a, n - 1, d + 1);

        // Return from intermediate recursive calls, we print
        // the value of power1(a, n-1) as well.
        printIndented(d, "return " + result + " * " + a);
        return result * a;
    }
}

public static void main(String [] args) {
    System.out.println(power1(1.4, 3, 0));
}