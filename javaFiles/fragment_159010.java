@SpringBootApplication
@EnableConfigurationProperties(AzureProperties.class)
@EnableDatabaseManagement
@PropertySource(value = "classpath:/secure.properties", ignoreResourceNotFound = true)
public class Application {
    public static void main(String[] args) throws EventHubException, IOException, InterruptedException, ExecutionException {
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UCT"));
        DateTimeZone.setDefault(DateTimeZone.forID("Etc/UCT"));
        SpringApplication.run(Application.class, args);
    }
}