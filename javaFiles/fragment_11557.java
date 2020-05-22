public static int factorial (int n) {
    return privateFactorial(n, false);
}

private static int privatefactorial(int n, boolean calledRecursively) {
    System.out.println(calledRecursively);
    if (n == 0) {
        return 1;
    }
    else {
        return n * privateFactorial(n-1, true);  // tell next invocation here!
    }
}