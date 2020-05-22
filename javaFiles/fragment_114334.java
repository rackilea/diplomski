@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MyAppIT {

    @Autowired
    public ConfigurableEnvironment environment;

    @Autowired
    public SomeOtherBean otherBean;

    @Autowired
    public RefreshScope refreshScope;

    @Test
    public void testRefresh() {
        assertEquals("Hello World!", otherBean.getGreeting());

        EnvironmentTestUtils.addEnvironment(environment, "my.property=Mars");
        refreshScope.refreshAll();

        assertEquals("Hello Mars!", otherBean.getGreeting());
    }
}