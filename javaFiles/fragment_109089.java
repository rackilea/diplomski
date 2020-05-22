@Configuration
@ComponentScan(basePackages = {"spittr"},
    excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
public class RootConfig {
}