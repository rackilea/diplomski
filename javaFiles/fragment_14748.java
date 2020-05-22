import static java.util.stream.Collectors.toList;
import static java.util.concurrent.CompletableFuture.supplyAsync;

ExecutorService threads = Executors.newFixedThreadPool(25);

List<MyObject> result = fileNames.stream()
        .map(fn -> supplyAsync(() -> readObjectFromS3(fn), threads))
        .collect(toList()).stream()
        .map(CompletableFuture::join)
        .collect(toList());