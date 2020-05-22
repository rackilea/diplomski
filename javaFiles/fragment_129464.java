@EnableWebMvc 
@Configuration
@ComponentScan(
  basePackages ={ "com.myapp" }, 
  excludeFilters = { 
    @Filter(type = FilterType.ANNOTATION, value = Configuration.class)
  }
)