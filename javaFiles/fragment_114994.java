@BeforeClass
  public static void before2(TestContext context){
    Async async = context.async();
    vertx = Vertx.vertx();
    DeploymentOptions options = new DeploymentOptions();
    byte[] encoded;
    JsonObject config;

    try {
      encoded = Files.readAllBytes(Paths.get("src/main/resources/config.json"));
      config = new JsonObject(new String(encoded, Charset.defaultCharset()));
      options.setConfig(config);
      jdbc = JDBCClient.createShared(vertx, config , "PostgreSQL");

      deployVerticle2(options)
        .compose(c -> loadTestData2(jdbc))
        .setHandler(h -> {
          if(h.succeeded()){
            async.complete();
          }else{
            context.fail(h.cause());
          }
        });

    } catch (IOException e){
      context.fail(e);
    }
  }