public static int fibo(int n) {
    if (n < 0) {
        throw new IndexOutOfBoundsException("Can't calculate fibonacci number for negative index");
    } else if(n == 0 || n == 1) {
        return n;
    }

    return fibo(n-1) + fibo(n-2);
}