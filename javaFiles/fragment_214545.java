/**
* Bridge the StreamObserver from gRPC to the Publisher from the reactive world.
*/
public class StreamObserverPublisher implements Publisher<Long>, StreamObserver<Long> {

    private Subscriber<? super Long> subscriber;

    @Override
    public void onNext(Long l) {
        subscriber.onNext(l);
    }

    @Override
    public void onError(Throwable throwable) {
        subscriber.onError(throwable);
    }

    @Override
    public void onCompleted() {
        subscriber.onComplete();
    }

    @Override
    public void subscribe(Subscriber<? super Long> subscriber) {
        this.subscriber = subscriber;
        this.subscriber.onSubscribe(new BaseSubscriber() {});
    }
}

// and somewhere else in the code
StreamObserverPublisher streamObserverPublisher = new StreamObserverPublisher();
Flux<Long> longFlux = Flux.from(streamObserverPublisher);
longFlux.subscribe(...); // must be done before executing the gRPC request
MyGrpcService.newStub(channel).getResponses(protoRequest, streamObserverPublisher);