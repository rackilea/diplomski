@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE, properties={"app.datasource.alternate.schema-username=TEST",
"app.datasource.alternate.username=SOMETHING"})
@ActiveProfiles("test") // there is a default test datasource configured in application-test.properties so I can test that primary configuration is unaffected. i.e. I have a H2 datasource configured here with username 'sa'
public class AlternateDataSourcePropertiesConfigurationTest {

    @Autowired
    @Qualifier("alternateDataSourceProperties")
    private DataSourceProperties alternateDataSourceProperties;

    @Autowired
    private DataSourceProperties primaryDataSourceProperties;

    @Test
    public void propertiesAreInjected() {
        assertThat(alternateDataSourceProperties.getSchemaUsername()).isEqualTo("TEST");
    }

    @Test
    public void propertiesDontOverridePrimary() {
        assertThat(alternateDataSourceProperties.getUsername()).isEqualTo("SOMETHING");
        assertThat(primaryDataSourceProperties.getUsername()).isEqualTo("sa");
    }
}