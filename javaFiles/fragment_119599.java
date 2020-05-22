import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
public class MapBindingSample {

    public static void main(String[] args) throws Exception {
        System.out.println(SpringApplication.run(MapBindingSample.class, args)
                .getBean(Test.class).getInfo());
    }

    @Bean
    @ConfigurationProperties
    public Test test() {
        return new Test();
    }

    public static class Test {

        private Map<String, Object> info = new HashMap<String, Object>();

        public Map<String, Object> getInfo() {
            return this.info;
        }
    }
}