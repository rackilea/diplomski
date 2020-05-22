@Deployment
public static Archive<?> createDynamicDeployment() {
  if(<ear condition>) {
    EnterpriseArchive ear = ShrinkWrap.createFromZipFile(EnterpriseArchive.class, new File("some_archive.ear"))
            .addAsModule(Testable.archiveToTest(ShrinkWrap.create(WebArchive.class, "test.war")
                        .addClass(SoftCountFacadeTest.class)
                        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")));
    return ear;
  } else {
    WebArchive war = ShrinkWrap.create(WebArchive.class).addClass(Test.class)
            .addAsManifestResource(new File("jboss-deployment-structure.xml"))
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    return war;
  }
}