import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * This class loads the property file and returns the property file values.
 *
 */
@Component
@Configuration
@PropertySource("classpath:errors.properties")
public class ApplicationProperties {

    @Autowired
    private Environment env;

    public static String getProperty(final String key) {
        return env.getProperty(key, "");
    }
}