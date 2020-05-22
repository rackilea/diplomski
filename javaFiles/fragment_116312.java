@Deployment(name = "JAR-C", managed = false)
public static WebArchive create() {
  return ShrinkWrap.create(JavaArchive.class);
}

@ArquillianResource
private Deployer deployer;

@Test
public void should_work() {
  deployer.deploy("JAR-C");
  // test
  deploy.undeploy("JAR-C");
}