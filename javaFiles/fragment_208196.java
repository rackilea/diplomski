public static void fib(int n){

    int Fibonacci [] = new int[n];
    Fibonacci [0]=1;
    Fibonacci [1]=1;

    for (int i = 2; i < n; i++) {

        Fibonacci [i]=Fibonacci [i-1]+Fibonacci [i-2];

    }

    System.out.println(Arrays.toString(Fibonacci ));
}