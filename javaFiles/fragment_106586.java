import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myproperty-file.properties")
@ConfigurationProperties(prefix = "search")
public class MypropConfigProperties {
 private Map<String, String> myprop;

 public Map<String, String> getMyProp() {
    return myprop;
}

public void setMyProp(Map<String, String> myprop) {
        this.myprop= myprop;
    }
}