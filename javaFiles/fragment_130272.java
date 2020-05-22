@Configuration
@ComponentScan(basePackageClasses= {BlocBuilder.class,... all my classes go here})
public class AppConfig {

  @Bean
  public SomeInterface someInterface() {
      return new SomeInterfaceImpl();
  }

  @Bean
  @Scope("prototype")
  public BlocBuilder blocBuilder(){ 
      return new BlocBuilder(someInterface());
  }
}