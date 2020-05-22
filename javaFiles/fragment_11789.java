@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=OFAC.class)
public class OFAConfigurationTest {

    @Autowired
    private Environment environment;

    @Autowired
    private ConfigurationSettings configurationSettings;

    @Test
    public void testConfigurationLoads() {
        assertNotNull(environment);
        assertNotNull(configurationSettings);
    }

    @Test
    public void testConfigurationSettingValues() {
        assertEquals("Product Name", configurationSettings.getProduct());
        assertEquals("0.0.1", configurationSettings.getVersion());
        assertEquals("2014 Product", configurationSettings.getCopyright());
    }