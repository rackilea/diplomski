public class AddHeaderExchangeFilter implements ExchangeFilterFunction {

        @Override
        public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {

            ClientRequest newRequest = ClientRequest.create(request.method(), request.url())
                                                    .headers(httpHeaders -> httpHeaders.addAll(request.headers()))
                                                    .header("FILTER-HEADER-KEY", "FILTER-HEADER-VALUE")
                                                    .build();
            return next.exchange(newRequest);
        }
    }