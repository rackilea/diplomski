public class HttpRequestBody {

    // adapt Flow.Subscriber<List<ByteBuffer>> to Flow.Subscriber<ByteBuffer>
    static final class StringSubscriber implements Flow.Subscriber<ByteBuffer> {
        final BodySubscriber<String> wrapped;
        StringSubscriber(BodySubscriber<String> wrapped) {
            this.wrapped = wrapped;
        }
        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            wrapped.onSubscribe(subscription);
        }
        @Override
        public void onNext(ByteBuffer item) { wrapped.onNext(List.of(item)); }
        @Override
        public void onError(Throwable throwable) { wrapped.onError(throwable); }
        @Override
        public void onComplete() { wrapped.onComplete(); }
    }

    public static void main(String[] args) throws Exception {
        var request = HttpRequest.newBuilder(new URI("http://example.com/blah"))
                .POST(BodyPublishers.ofString("Lorem ipsum dolor sit amet"))
                .build();

        // you must be very sure that nobody else is concurrently 
        // subscribed to the body publisher when executing this code,
        // otherwise one of the subscribers is likely to fail.
        String reqbody = request.bodyPublisher().map(p -> {
            var bodySubscriber = BodySubscribers.ofString(StandardCharsets.UTF_8);
            var flowSubscriber = new StringSubscriber(bodySubscriber);
            p.subscribe(flowSubscriber);
            return bodySubscriber.getBody().toCompletableFuture().join();
        }).get();
        System.out.println(reqbody);
    }

}