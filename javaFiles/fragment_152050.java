import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class PropsConfig {

    @Value("${my.property}")
    private String myProperty;

    //any other properties...

    public String getMyProperty() { 
        return this.myProperty; 
    }