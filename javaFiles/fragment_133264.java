Feign.Builder builder = Feign.builder()
            .client(client)
            .encoder(usedEncoder)
            .decoder(decoder)
            .contract(feignContract)
            .logger(new Slf4Logger())
            .logLevel(Logger.Level.HEADERS);

        builder.requestInterceptor(new RequestInterceptor() {

            @Override
            public void apply(RequestTemplate template) {
                template.header("X-Service-Name", serviceName);
            }
        });