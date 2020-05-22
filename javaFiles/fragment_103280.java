public static void main(String[] args) {
    int sum = 0;

    //warmup
    for (int i = 0; i < 100; i++) {
        solve();
        solveLambda();
        solveLambdaParallel();
    }

    {
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            sum += solve();
        }
        long end = System.nanoTime();
        System.out.println("loop: " + (end - start) / 1_000_000);
    }
    {
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            sum += solveLambda();
        }
        long end = System.nanoTime();
        System.out.println("lambda: " + (end - start) / 1_000_000);
    }
    {
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            sum += solveLambdaParallel();
        }
        long end = System.nanoTime();
        System.out.println("lambda parallel : " + (end - start) / 1_000_000);
    }
    System.out.println(sum);
}

public static int digitSum(BigInteger x) {
    int sum = 0;
    for (char c : x.toString().toCharArray()) {
        sum += Integer.valueOf(c + "");
    }
    return sum;
}

public static int solve() {
    int max = 0;
    for (int i = 1; i < 100; i++) {
        for (int j = 1; j < 100; j++) {
            max = Math.max(max, digitSum(BigInteger.valueOf(i).pow(j)));
        }
    }
    return max;
}

public static int solveLambda() {
    return  IntStream.range(1, 100)
            .map(i -> IntStream.range(1, 100).map(j -> digitSum(BigInteger.valueOf(i).pow(j))).max().getAsInt())
            .max().getAsInt();
}

public static int solveLambdaParallel() {
    return  IntStream.range(1, 100)
            .parallel()
            .map(i -> IntStream.range(1, 100).map(j -> digitSum(BigInteger.valueOf(i).pow(j))).max().getAsInt())
            .max().getAsInt();
}