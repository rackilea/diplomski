ResteasyProviderFactory factory = new ResteasyProviderFactory();
RegisterBuiltin.register(factory);
factory.getClientExecutionInterceptorRegistry().register(
    new ClientExecutionInterceptor() {
        @Override
        public ClientResponse execute(ClientExecutionContext ctx) throws Exception {
            ClientResponse response = ctx.proceed();
            if("text/javascript".equals(response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE))){
                response.getHeaders().putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
            }
            return response;
        }
    });


ProxyFactory.create(Service.class, URI.create("http://url-to-your-sevice"), new ApacheHttpClient4Executor(), factory);