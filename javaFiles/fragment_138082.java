import java.util.Properties;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MortgageLoanApiApplication.class).properties(loadproperties());
    }

    /**
     * Added this method to load properties from the classpath while intializing the server app
     * location of the properties file should be inside tomcat directory:
     *    lib/mortgage-api/application.properties
     * @return
     */
    private Properties loadproperties() {
          Properties props = new Properties();
          props.put("spring.config.location", "classpath:mortgage-api/");
          return props;
       }

}