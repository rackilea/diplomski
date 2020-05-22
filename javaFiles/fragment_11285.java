import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mcf.xml.free.route")
public class RouteJavaConfig extends CamelConfiguration {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.setConfigClass(RouteJavaConfig.class);
        main.run();
    }
}