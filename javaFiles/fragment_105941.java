List<byte[]> delimiterBytes = getDelimiterBytes(mimeType);

Flux<DataBuffer> inputFlux = Flux.from(input)
    .flatMapIterable(buffer -> splitOnDelimiter(buffer, delimiterBytes))
    .bufferUntil(buffer -> buffer == END_FRAME)
    .map(StringDecoder::joinUntilEndFrame)
    .doOnDiscard(PooledDataBuffer.class, DataBufferUtils::release);

return super.decode(inputFlux, elementType, mimeType, hints);