channel.eventLoop().execute(new Runnable() {
  @Override
  public void run() {
    channel.write(msg1);
    channel.writeAndFlush(msg3);
  }
});