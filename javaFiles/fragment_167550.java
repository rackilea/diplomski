import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfiguration {

    @Autowired
    private MyCompanyConfigurationProperties myCompanyConfProps;

    @PostConstruct
    public void testProperteis() {
        System.out.println("My Properties: " + myCompanyConfProps.getSchedule());
    }

}