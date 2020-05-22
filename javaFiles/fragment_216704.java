FileWatchService watcher = ...

Flux<File> fileFlux = Flux.push(sink -> {
    watcher.onError(err -> sink.error(err));
    watcher.onNewFile(file -> sink.next(file));
});

fileFlux
    .onBackPressureBuffer(10, BufferOverflowStrategy.DROP_LATEST)
    .subscribe(...)