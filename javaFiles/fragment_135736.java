@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig {

    @Configuration
    @Order(1)
    public static class CaptchaApiConfigurerAdatper extends WebSecurityConfigurerAdapter {

        @Autowired
        private CaptchaFilter captchaFilter;

        public CaptchaApiConfigurerAdatper() {
            super(true);
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                    .ignoring()
                    .antMatchers("/public/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .requestMatchers()
                        .antMatcher("/iapi/captcha**")
                        .antMatcher("/external/captcha**")
                        .and()
                    .addFilterBefore(captchaFilter, (Class<? extends Filter>) ChannelProcessingFilter.class)
                    .authorizeRequests()
                        .anyRequest().authenticated();
        }
    }            

    @Configuration
    @Order(2)
    public static class InternalApiConfigurerAdapter extends WebSecurityConfigurerAdapter {

        // ommiting code for the sake of clarity
    }

    @Configuration
    @Order(3)
    public static class ExternalApiConfigurerAdapter extends WebSecurityConfigurerAdapter {

         // ommiting code for the sake of clarity
    }