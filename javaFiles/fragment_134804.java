@Configuration
@EnableGlobalMethodSecurity
public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    return new OAuth2MethodSecurityExpressionHandler();
  }
}

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  ...
}


@Configuration
@Import({ SecurityConfiguration.class, MethodSecurityConfiguration.class })
public class AppConfiguration {
  ...
}