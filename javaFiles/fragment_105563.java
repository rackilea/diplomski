@ContextConfiguration(loader = SpringockitoContextLoader.class,
locations = "classpath:/context.xml")
public class SpringockitoAnnotationsMocksIntegrationTest extends AbstractJUnit4SpringContextTests {

    @ReplaceWithMock
    @Autowired
    private InnerBean innerBean;

...
}