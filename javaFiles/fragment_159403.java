System.out.println(
    generateRandom(1, 100)
        .thenApply(this::printEvenOrOdd)
        .thenCompose(result ->
            result % 2 == 0
                ? findFactorial(result)
                : convertToNearestEvenInteger(result)
        )
        .join()
);