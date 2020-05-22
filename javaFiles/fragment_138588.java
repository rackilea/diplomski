class LengthPrefixedStream implements ReadStream<Buffer> {
  final RecordParser recordParser;
  boolean prefix = false;

  private LengthPrefixedStream(ReadStream<Buffer> stream) {
    recordParser = RecordParser.newFixed(4, stream);
  }

  @Override
  public ReadStream<Buffer> exceptionHandler(Handler<Throwable> handler) {
    recordParser.exceptionHandler(handler);
    return this;
  }

  @Override
  public ReadStream<Buffer> handler(Handler<Buffer> handler) {
    if (handler == null) {
      recordParser.handler(null);
      return this;
    }
    recordParser.handler(buffer -> {
      if (prefix) {
        prefix = false;
        recordParser.fixedSizeMode(buffer.getInt(0));
      } else {
        prefix = true;
        recordParser.fixedSizeMode(4);
        handler.handle(buffer);
      }
    });
    return this;
  }

  @Override
  public ReadStream<Buffer> pause() {
    recordParser.pause();
    return this;
  }

  @Override
  public ReadStream<Buffer> resume() {
    recordParser.resume();
    return this;
  }

  @Override
  public ReadStream<Buffer> endHandler(Handler<Void> endHandler) {
    recordParser.endHandler(endHandler);
    return this;
  }
}