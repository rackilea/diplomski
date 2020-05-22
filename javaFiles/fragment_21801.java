public class PlainTextChannelProvider implements ChannelProvider {
  @Override
  public boolean shouldAutoClose() {
    return false;
  }

  @Override
  public boolean needsExecutor() {
    return false;
  }

  @Override
  public ManagedChannel getChannel() throws IOException {
    return NettyChannelBuilder.forAddress("localhost", 8085)
      .negotiationType(NegotiationType.PLAINTEXT)
      .build();
  }

  @Override
  public ManagedChannel getChannel(Executor executor) throws IOException {
    return getChannel();
  }
}