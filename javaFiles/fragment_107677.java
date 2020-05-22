@RunWith(Arquillian.class)
public class EchoServiceBeanTest {

    @EJB
    private EchoService echoService;

    @Deployment
    public static Archive<?> createDeployment() {
        // create ear
        EnterpriseArchive ear = ShrinkWrap
                .create(EnterpriseArchive.class, "test-app.ear");

        // create ejb.jar
        JavaArchive ejb = ShrinkWrap
                .create(JavaArchive.class, "test-ejb.jar")
                .addPackages(true, "a.b.ejb")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        LOGGER.debug("EJB content: " + ejb.toString(true));

        // build ear
        ear.addAsModule(ejb);

        LOGGER.debug("EAR deployment content: " + ear.toString(true));
        return ear;
    }

    @Test
    public void echo() throws Exception {
        Assert.assertNotNull(echoService);
        String expected = "hello";
        String returned = echoService.echo(expected);
        Assert.assertEquals(expected, returned);
    }
}