public int[] fibonacci(int size) {
    int[] res = new int[size];
    res[0] = 0;
    res[1] = 1;
    for (int i = 2; i < size; i++) {
        res[i] = res[i - 1] + res[i - 2];
    }
    return res;
}

public static void main(String[] args) {
    FibonacciSequence fbs = new FibonacciSequence();
    int[] arrayREs = fbs.fibonacci(10);
    System.out.println(Arrays.toString(arrayREs));
}