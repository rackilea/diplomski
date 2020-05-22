@Configuration
@Import({ServicesBaseConfiguration.Filtered.class, ServicesBaseConfiguration.Unfiltered.class})
public class ServicesBaseConfiguration {

    @Configuration
    @ComponentScan(basePackages = "com.example.business", includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ServiceComponent.class))
    public static class Filtered {}

    @Configuration
    @ComponentScan(basePackages = "com.example.business.framework")
    public static class Unfiltered {}

}