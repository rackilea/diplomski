@Configuration
@ImportResource({"${conf.dir}/context.xml"})
public class AppConfig {
 static {
    if(!System.getProperties().contains("conf.dir")) {
        System.setProperty("conf.dir", "classpath:");
    }
 }
 @Autowire somethingFromAboveXmlContext;
}