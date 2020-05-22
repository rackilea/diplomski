@Configuration
@EnableConfigurationProperties(value = {UserLimitReader.class})
public class SpringConfiguration {
    ...
}

@ConfigurationProperties(prefix = "countries", locations: "classpath:config/application.yaml")
public class UserLimitReader {
    ...
}