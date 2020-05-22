channel.eventLoop().execute(new Runnable() {
  @Override
  public void run() {
    channel.write(msg1);
  }
});
channel.eventLoop().execute(new Runnable() {
  @Override
  public void run() {
    channel.writeAndFlush(msg3);
  }
});