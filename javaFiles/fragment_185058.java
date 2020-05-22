CloseableHttpClient client = CachingHttpClients.custom()
            .addInterceptorLast((HttpRequestInterceptor) (request, context) -> {
                String method = request.getRequestLine().getMethod();
                String requestUri = request.getRequestLine().getUri();
                request.addHeader("x-my-header", doSomethingClever(method, requestUri));

            })
            .build();