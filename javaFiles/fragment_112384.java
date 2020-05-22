public class Test {

  @Test
  public void test() {
    String[] args = new String[]{"initParams"}; // To adapt
    ConfigurableApplicationContext ctx = SpringApplication.run(MyApp.class, args);
    // whatever
    ctx.close();
    // whatever after the app has terminated.
  }
}