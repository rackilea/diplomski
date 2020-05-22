@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@EnableJpaRepositories
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = { "mypackage.spring.rest" }, excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Configuration.class))
public class SpringRestConfiguration {

}