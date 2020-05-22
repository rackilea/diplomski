AtomicInteger receivedCount= new AtomicInteger();
@Override
public void onResponseReceived() {
    if (receivedCount.incrementAndGet() == totalCount){
        onCallbacksComplete();
    }
}