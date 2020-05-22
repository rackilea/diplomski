@Configuration
@EnableBatchProcessing
@Import(YourDataSourceConfiguration.class)
public class BatchConfiguration {
   @Autowired
   private  DataSource dataSource;
   ....