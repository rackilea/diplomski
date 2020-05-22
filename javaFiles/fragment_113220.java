public int fibonacci(int numArray[]) {
    for (int i = 1; i < numArray.length - 1; i++) {
        System.out.print(numArray[i] + numArray[i - 1] + " ");
    }
    return numArray[10];
}

public static void main(String[] args) {
    FibonacciSequence fbs = new FibonacciSequence();
    fbs.fibonacci(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});      
}