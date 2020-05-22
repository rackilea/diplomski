@Deployment(name = "SandboxTest")
public static Archive<?> createTestArchive() {


    File[] lib1 = Maven.configureResolver().loadPomFromFile("pom.xml")  
.importCompileAndRuntimeDependencies().resolve().withTransitivity().asFile();


    return ShrinkWrap.create(WebArchive.class, "SandboxTest.war")
            .addAsLibraries(lib1)  //add lib1
            .addPackages(true, PersonT.class.getPackage(),
                    PersonDTO.class.getPackage(),
                    PersonRepository.class.getPackage(),
                    CurrentUser.class.getPackage(),
                    Service.class.getPackage(),
                    BaseTest.class.getPackage())
            .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
            .addAsResource("log4j.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsWebInfResource("weblogic.xml");
}