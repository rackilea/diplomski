public class MessageSecurityWebApplicationInitializer extends
        AbstractSecurityWebApplicationInitializer { //register the springSecurityFilterChain with the war

}


public class MessageWebApplicationInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SecurityConfig.class }; //make sure your config file gets loaded
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return null;
    }


   @Configuration
   @EnableWebMvcSecurity
   public class SecurityConfig extends WebSecurityConfigurerAdapter {
     @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        System.err.println("in here");
        auth.inMemoryAuthentication().withUser("user@yahoo.com")
                .password("password").roles("USER"); //access to inmemory credentials
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
                .antMatchers("/resources/**", "/", "/index", "/aboutus")
                .permitAll() //allow access to your static pages and resources
                .antMatchers("/profile/**")
                .hasRole("USER") //profile address is only available to users ( do not need to add ROLE_ as Spring does it for you)
                .and() //and is equivalent of end tag in XML 
                .formLogin().loginPage("/signin").failureUrl("/signin?error")
                .permitAll().and().logout().logoutUrl("/singout").permitAll();
    }