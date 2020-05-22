@EnableWebSecurity
@Configuration
@PropertySource("classpath:config.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    ...
}

@EnableGlobalMethodSecurity
@Configuration
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Value("${securityconfig.enabled}")
    private boolean securityEnabled;

    protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
        return securityEnabled ? new SecuredAnnotationSecurityMetadataSource() : null;
    }    
}