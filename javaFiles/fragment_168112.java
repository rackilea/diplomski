private static void generateFibonacci(int beginIndex, int lastIndex) {

    int len = lastIndex + 1;
    int[] fib = new int[len];
    fib[0] = 0; 
    fib[1] = 1;

    // Building Fibonacci sequence from beginIndex through lastIndex
    for (int i = 2; i < len; ++i)
        fib[i] = fib[i-1] + fib[i-2];

    // Printing 
    for (int index = beginIndex; index <= lastIndex; ++index) {

        if ((fib[index] % 5 == 0) && (fib[index] % 7 == 0)) {
            System.out.println("Hi I am me");
        }
        else if (fib[index] % 5 == 0) { 
            System.out.println("Hi");
        }
        else if (fib[index] % 7 == 0) {
            System.out.println("I am");
        }
        else {
            System.out.println(fib[index]);
        }
    }
}