Flux<DataBuffer> incoming = client.post()
      .retrieve().bodyToFlux(DataBuffer.class);
Mono<Void> writeOperation = DataBufferUtils.write(incoming, channel)
      .map(DataBufferUtils::release)
      .then();
// subscribe to the returned value, which will complete when writing is done