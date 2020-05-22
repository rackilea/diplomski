AtomicInteger receivedCount= new AtomicInteger(totalCount);
@Override
public void onResponseReceived() {
    if (receivedCount.decrementAndGet() == 0){
        onCallbacksComplete();
    }
}