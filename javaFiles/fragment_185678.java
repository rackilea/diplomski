import static java.util.concurrent.CompletableFuture.allOf;
import static java.util.concurrent.CompletableFuture.runAsync;

runAsync(() -> doTask1(), executor)
        .thenCompose(v -> allOf(
                runAsync(() -> doTask2(), executor),
                runAsync(() -> doTask3(), executor),
                runAsync(() -> doTask4(), executor)
        ));