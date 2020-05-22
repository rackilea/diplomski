@SpringBootApplication
@EnableConfigurationProperties(SportsProperties.class)
public class YamlSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(YamlSampleApplication.class, args);
    }

}