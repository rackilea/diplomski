@RunWith(Arquillian.class)
public abstract class TestBundle{
     @Deployment
     public static WebArchive createTestArchive() {
         return ShrinkWrap
            .create(WebArchive.class, "testArchive.war")
            .addClass(CustomerListProducer.class)
            .addPackage("company.product.controller")
            .addPackage("company.product.model")
            .addPackage("company.product.util")
            .addPackage("company.product.services")
            .addPackage("company.product.test")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsWebInfResource("test-ds.xml", "product-ds.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
     }
}