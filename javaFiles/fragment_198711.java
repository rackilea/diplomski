final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    final HttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(
            new DefaultRedirectStrategy() {
                @Override
                public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context) throws ProtocolException {
                    return false;
                }
            }
    ).build();
    factory.setHttpClient(httpClient);
    restTemplate.setRequestFactory(factory);