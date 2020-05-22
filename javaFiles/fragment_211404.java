Consumer<ClientCodecConfigurer> consumer = configurer ->
        configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder() {
            @Override
            public Flux<DataBuffer> encode(Publisher<?> inputStream, DataBufferFactory bufferFactory, ResolvableType elementType, @Nullable MimeType mimeType, @Nullable Map<String, Object> hints) {
                return super.encode(inputStream, bufferFactory, elementType, mimeType, hints)
                        .doOnNext(dataBuffer -> System.out.println(StandardCharsets.UTF_8.decode(dataBuffer.asByteBuffer()).toString()));
            }
        });

WebClient webClient = WebClient.builder()
        .exchangeStrategies(ExchangeStrategies.builder().codecs(consumer).build())
        .build();