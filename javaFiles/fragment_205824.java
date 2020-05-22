public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        final DefaultHttpFirewall firewall = new DefaultHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
    }
}

 public class AppConfig extends WebMvcConfigurationSupport {

    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        final RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
        requestMappingHandlerMapping.setUrlDecode(false);
        return requestMappingHandlerMapping;
    }
}