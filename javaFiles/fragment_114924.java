public class SomeProcessingServiceIntegrationTest extends AbstractOpenEJBTestNG {

@EJB
SomeProcessingServiceLocal processingService;

@Module
public EjbModule beans() {

    EjbJar ejbJar = new EjbJar("processing");
    OpenejbJar openejbJar = new OpenejbJar();

    ejbJar.addEnterpriseBean(new StatelessBean(SomeProcessingService.class));
    ejbJar.addEnterpriseBean(new StatelessBean(DatabaseLookupService.class));
}
@Test
public void testProcessingService(){
     // Should return true for example
     assertTrue(processingService.process());
}
}

@Stateless
@Local(SomeProcessingServiceLocal.class)
public class SomeProcessingService {

@EJB
DatabaseLookupServiceLocal databaseLookupService;

    public boolean process(){
         return databaseLookupService.existsInDB();
    }
}