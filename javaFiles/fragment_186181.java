int count = 0;
while(receivingPackets) {
    ...
    completionService.submit(splitPacketCallable);
    ++count;
    ...
    try {
        Future<Data> dataFuture = completionService.poll();
        if (dataFuture != null) {
            --count;
            ...
        }
    ...
}

// Finish any remaining threads
while (count-- > 0) {
    ...    
}