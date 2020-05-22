@Configuration
 @EnableWebSecurity
 public class HttpSecurityConfig extends WebSecurityConfigurerAdapter {

     @Autowired  CookieReferrerFilter cookieFilter;

     @Autowired CharacterEncodingFilter encodingFilter;

     @Override
     protected void configure(HttpSecurity http) throws Exception {
         http
             .addFilterBefore(cookieFilter, ChannelProcessingFilter.class)
             .addFilterBefore(encodingFilter, ChannelProcessingFilter.class)
               //your configuration follows here
                ; 
      }
   }