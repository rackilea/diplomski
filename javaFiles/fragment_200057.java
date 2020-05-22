@Configuration
@Profile({"dev","prod"})
public class JobRepositorySchemaConfig {
private final String JOB_REPO_SCHEMA = "classpath:batch_repo_schema.sql";

@Autowired
@Qualifier("secondDatasource")
DataSource datasource;

@Autowired
WebApplicationContext webApplicationContext;

@PostConstruct
public void loadIfInMemory() throws Exception {
    Resource resource = webApplicationContext.getResource("classpath:/org/springframework/batch/core/schema-drop-hsqldb.sql");
    Resource resource2 = webApplicationContext.getResource("classpath:/org/springframework/batch/core/schema-hsqldb.sql");
    ScriptUtils.executeSqlScript(datasource.getConnection(), resource);
    ScriptUtils.executeSqlScript(datasource.getConnection(), resource2);
}