@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="props.a")
public class A implements ConfigInterface {
  private ... value1;
  private ... value2;
  //getters setters
}

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="props.b")
public class B implements ConfigInterface {
  private ... value1;
  private ... value2;
  //getters setters
}