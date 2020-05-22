@Override
public void getData(RequestValue requestValue, StreamObserver<ResponseValue> responseObserver) {
    Runnable r = () -> {
        try {
            ResponseValue rv = ... // blocking code here
            responseObserver.onNext(rv);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
    }
    executor.schedule(r);
}