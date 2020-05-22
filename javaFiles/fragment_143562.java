@RunWith(VertxUnitRunner.class) 
public class TestMyStuff {
   private Vertx vertx;

   final AtomicBoolean loaded = new AtomicBoolean(false);

   @Before
   public void setUp(TestContext context) throws IOException {
    ClusterManager mgr = new HazelcastClusterManager();
    VertxOptions options = new VertxOptions().setClusterManager(mgr);
    Vertx.clusteredVertx(options, new Handler<AsyncResult<Vertx>>() {
        @Override
        public void handle(AsyncResult<Vertx> res) {
            if (res.succeeded()) {
                vertx = res.result();

                DeploymentOptions options = new DeploymentOptions()
                        .setConfig(new JsonObject().put("http.port", 8080)
                        );
                //vertx.deployVerticle(MyWebService.class.getName(), options, context.asyncAssertSuccess());
                System.out.println("SUCCESS");
                loaded.set(true);
            } else {
                System.out.println("FAILED");
            }
         }
       });
   }

   @Test
   public void printSomething(TestContext context) {


    Awaitility.waitAtMost(Duration.ONE_MINUTE).await().untilTrue(loaded);
    System.out.println("Print from method printSomething()");
   }
}