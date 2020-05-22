@RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = { "classpath*:spring-context.xml" })
    public class fooTest {

        @Inject
        private DomainService service;
        [...]