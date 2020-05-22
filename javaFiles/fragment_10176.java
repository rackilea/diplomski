public static long fibonacci(int depth, int n) {
    String indent = new String(new char[depth]).replace('\0', ' ');
    long result;
    if (n == 0 || n == 1) {
        result = n;
        System.out.printf(indent + "fib(%s)-->%s%n", n, result);
    } else {
        long first = fibonacci(depth+1, n - 1);
        System.out.printf(indent + "fib(%s)%n", n);
        long second = fibonacci(depth+1, n - 2);
        result = first + second;
    }
    return result;
}

public static void main(String args[]) {
    fibonacci(0, 5);
}