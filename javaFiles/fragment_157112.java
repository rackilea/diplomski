@Configuration
@Profile("hsqldb")
@ImportResource(value = { "persistence-config.xml" })
@Slf4j
public class HsqlConfiguration {

    @Autowired
    private TenantDbProperties tenantDbProperties;

    //code goes here where you can use tenantDbProperties.getDataSourceConfigs()
}