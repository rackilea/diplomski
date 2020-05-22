final AtomicLong concurrentExchangeCount = new AtomicLong(0);

final HttpClientBuilder httpClientBuilder = new HttpClientBuilder() {

    @Override
    protected ClientExecChain decorateMainExec(final ClientExecChain mainExec) {
        return (route, request, clientContext, execAware) -> {
            concurrentExchangeCount.incrementAndGet();
            try {
                return mainExec.execute(route, request, clientContext, execAware);
            } finally {
                concurrentExchangeCount.decrementAndGet();
            }
        };
    }
};
final CloseableHttpClient httpClient = httpClientBuilder.build();