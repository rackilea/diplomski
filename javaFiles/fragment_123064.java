@ContextConfiguration
public class SoftwareServiceTests extends AbstractJUnit4SpringContextTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(SoftwareServiceTests.class.getName());

    @Autowired
    private SoftwareService softwareService;

    @Test(expected = ValidationException.class)
    public void testAddInvalidSoftware() throws ValidationException {
        LOGGER.info("Testing add invalid software");
        SoftwareObject softwareObject = new SoftwareObject();
        softwareObject.setName(null);
        softwareObject.setType(null);

        this.softwareService.addSoftware(softwareObject);
    }

    @Configuration
    @Import(AspectsConfiguration.class)
    public static class TestConfiguration {

        @Bean
        public SoftwareDAO softwareDao() {
            return Mockito.mock(SoftwareDAO.class);
        }

        @Bean
        public MapperFacade domainMapper() {
            return Mockito.mock(MapperFacade.class)
        }

        @Bean
        public SoftwareService softwareService() {
            SoftwareServiceImpl service = new SoftwareServiceImpl(softwareDao())
            return service;
        }

    }
}