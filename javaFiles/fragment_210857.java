@Deployment
public static WebArchive createDeployment() {
    //Load dependencies from POM
    final PomEquippedResolveStage pom = Maven
        .resolver()
        .loadPomFromFile("pom.xml");
    final PomEquippedResolveStage dependencies = pom
        .importCompileAndRuntimeDependencies();
    final File[] libs =         
      dependencies.resolve().withTransitivity().asFile();

    return ShrinkWrap
      .create(WebArchive.class,
              "ExampleArchive.war")
      .addPackage(org.example.Example.class.getPackage())
      .addAsLibraries(files)
      .addAsResource("test-persistence.xml",
                    "META-INF/persistence.xml")
      .addAsWebInfResource(EmptyAsset.INSTANCE, "WEB-INF/beans.xml"); 

}