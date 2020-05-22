public static void main(String[] args) throws Exception {
    RequestResponseService requestResponseService = new RequestResponseService();

    Request request = new Request();
    request.correlationId = 1;
    request.question = "Do you speak Spanish?";


    Mono<Request> requestMono = Mono.just(request)
            .doOnNext(rq -> System.out.println(rq.question));
    requestResponseService.doRequest(requestMono)
            .doOnNext(response -> System.out.println(response.answer))
            // The blocking call here is just so the application doesn't exit until the demo is completed.
            .block();
}

static class RequestResponseService {
    private final ConcurrentHashMap<Long, Consumer<Response>> responses =
            new ConcurrentHashMap<>();

    Mono<Response> doRequest(Mono<Request> request) {
        return request.flatMap(rq -> doNonBlockingFireAndForgetRequest(rq)
                .then(Mono.create(sink -> responses.put(rq.correlationId, sink::success))));
    }

    private Mono<Void> doNonBlockingFireAndForgetRequest(Request request) {
        return Mono.fromRunnable(this::simulateResponses);
    }

    private void processResponse(Response response) {
        responses.get(response.correlationId).accept(response);
    }

    void simulateResponses() {
        // This is just to make the example work. Not part of the example.
        new Thread(() -> {
            try {
                // Simulate a delay.
                Thread.sleep(10_000);

                Response response = new Response();
                response.correlationId = 1;
                response.answer = "Si!";

                processResponse(response);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}