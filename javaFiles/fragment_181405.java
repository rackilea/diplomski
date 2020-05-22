class MyVerticle2 extends AbstractVerticle {
  @Override
  public void start() {
    System.out.println("MyVerticle2 started!");
  }

  @Override
  public void stop() throws Exception {
    System.out.println("MyVerticle2 stopped!");
  }
}