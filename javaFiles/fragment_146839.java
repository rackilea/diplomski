CompletableFuture<Object> future = new CompletableFuture();

EventObjectListener eventListener = (topic, eventObject) -> 
        future.complete(eventObject);

try {
    return future.get(waitMagnitude, waitUnit);
} catch(Exception e) {
    return null;
} finally {
    eventReceiver.removeEventListener(eventListener);
}