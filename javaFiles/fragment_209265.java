import org.powermock.api.support.membermodification.MemberModifier;
...    
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    ApplicationContext contextToInject;
    @Autowired
    DomainA domainAAutowired;

    @Test
    public void contextLoads() throws IllegalArgumentException, IllegalAccessException {
        // Autowired spring beans work fine
        assertTrue(domainAAutowired.isContextInitilized());
        // Class out of spring context won't initialize dependencies
        DomainA domainOutOfSpringContext = new DomainA();
        assertFalse(domainOutOfSpringContext.isContextInitilized());
        // We can 'set' private members using PowerMock
        MemberModifier.field(DomainA.class, "context").set(domainOutOfSpringContext, contextToInject);
        assertTrue(domainOutOfSpringContext.isContextInitilized());
    }
}