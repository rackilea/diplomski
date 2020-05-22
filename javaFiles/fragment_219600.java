public class Main {

    private static class ApiResp {
        private final int last;
        private ApiResp(int last) {
            this.last = last;
        }
    }

    public static void main(String[] args) {
        queryBetween(0, 15)
                .doOnNext(apiResp -> System.out.println(apiResp.last))
                .blockLast();
    }

    public static Flux<ApiResp> queryBetween(int startInclusive, int endExclusive) {
        // The starting point of the next iteration
        final AtomicReference<Integer> nextIterationStart = new AtomicReference<>(startInclusive);
        return Flux
                // defer will cause a new Flux with a new starting point to be created for each subscription
                .defer(() -> queryFrom(nextIterationStart.get()))
                // update the starting point of the next iteration
                .doOnNext(apiResp -> nextIterationStart.set(apiResp.last + 1))
                // repeat with a new subscription if we haven't reached the end yet
                .repeat(() -> nextIterationStart.get() < endExclusive)
                // make sure we didn't go past the end if queryFrom returned more results than we need
                .takeWhile(apiResp -> apiResp.last < endExclusive);
    }

    public static Flux<ApiResp> queryFrom(int start) {
        // simulates an api call that always returns 10 results from the starting point
        return Flux.range(start, 10)
                .map(ApiResp::new);
    }
}