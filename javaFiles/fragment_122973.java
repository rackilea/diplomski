public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    if (n < 0) {
        System.out.println("Cannot computer Fib() of a negative number.");
        return(0);
    } else if (n < 3) {
       System.out.println("Fib[" + n + "] = 1");
    } else {
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 1;
        for(int i=2; i < f.length; ++i) {
            f[i] = f[i-1]+ f[i-2];
        }
        System.out.println("Fib[" + n + "] = " + f[n - 1]);
    }
}