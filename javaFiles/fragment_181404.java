class MyVerticle extends AbstractVerticle {
  @Override
  public void start(Future<Void> startFuture) {
    System.out.println("MyVerticle started!");
    startFuture.complete();
  }

  @Override
  public void stop(Future stopFuture) throws Exception {
    System.out.println("MyVerticle stopped!");
    stopFuture.complete();
  }
}