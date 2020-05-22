@Async
public CompletableFuture<FileDownloadResult> myDownloadFileAsync(...) {
    // download the file and create the result..
    return CompletableFuture.completedFuture(result);
}

...

CompletableFuture<FileDownloadResult> future = myDownloadFileAsync(...);
 
future.thenAccept(res -> {
    // do things with the file download result
    publishToKafka(...);
});

future.get();