import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(locations = "classpath:myapp.properties")
public class ApplicationProperties {

    private String property1;
    private Test2 test2;

    @Getter
    @Setter
    @ConfigurationProperties(prefix = "test2")
    public static class Test2 {
        @NotNull
        private String property2;
        @NotNull
        private String property3;
    }
}