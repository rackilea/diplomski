new AnnotationConfigWebApplicationContext().register(AnotherConfig.class);

@Configuration
@Import({MvcConfig.class})
public class AnotherConfig  {
....
}