public class RestletProducer extends DefaultAsyncProducer {

.......................................
......................................

 @Override
    public boolean process(final Exchange exchange, final AsyncCallback callback) {
        RestletEndpoint endpoint = (RestletEndpoint) getEndpoint();

        final RestletBinding binding = endpoint.getRestletBinding();
        Request request;
        try {
            String resourceUri = buildUri(endpoint, exchange);
            request = new Request(endpoint.getRestletMethod(), resourceUri);
            binding.populateRestletRequestFromExchange(request, exchange);
        } catch (CamelExchangeException e) {
            // break out in case of exception
            exchange.setException(e);
            callback.done(true);
            return true;
        }

        // process the request asynchronously
        LOG.debug("Sending request: {} for exchangeId: {}", request, exchange.getExchangeId());
        client.handle(request, new Uniform() {
            @Override
            public void handle(Request request, Response response) {
                LOG.debug("Received response: {} for exchangeId: {}", response, exchange.getExchangeId());
                try {
                    if (response != null) {
                        Integer respCode = response.getStatus().getCode();
                        if (respCode > 207 && throwException) {
                            exchange.setException(populateRestletProducerException(exchange, response, respCode));
                        } else {
                            binding.populateExchangeFromRestletResponse(exchange, response);
                        }
                    }
                } catch (Exception e) {
                    exchange.setException(e);
                }
            }
        });

        callback.done(false);
        return false;
    }