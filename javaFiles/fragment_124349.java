@Configuration
@PropertySource("spring.properties")
@EnableTransactionManagement
public class Test3 {
    @Autowired 
    Environment env;  

    @Bean 
    public ExecuteStoreProcedure getExecuteStoreProcedure() {
        ...
    }

    @Bean 
    public DataSource getDataSource() {
       ...
    }

    @Bean 
    public StoredProcedure getStoredProcedure() {
        return new MyStoredProcedure(getDataSource(), "proc1");
    }
...