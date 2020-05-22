static void fibFill(int[] fibo) {
    fibo[0] = 1;
    fibo[1] = 1;
    for (int i = 2; i < fibo.length; i++) {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
    }
}