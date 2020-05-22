supplyAsync(() -> doTask1(), executor)
        .thenCompose(resultOf1 -> allOf(
                runAsync(() -> doTask2(resultOf1), executor),
                runAsync(() -> doTask3(), executor),
                runAsync(() -> doTask4(), executor)
        ));