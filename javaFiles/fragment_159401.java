System.out.println(
    generateRandom(1, 100)
        .thenCompose(result ->
            printEvenOrOdd(result)
                .thenAccept(System.out::println)
                .thenApply(__ -> result)
        )
        .thenCompose(result ->
            result % 2 == 0
                ? findFactorial(result)
                : convertToNearestEvenInteger(result)
        )
        .join()
);