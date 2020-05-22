@Configuration
@EnableWebSecurity
public class TestSecurityConfiguration extends WebSecurityConfigurerAdapter{
   @Override
   protected void configure(HttpSecurity http) throws Exception {
   http.csrf().disable().authorizeRequests().anyRequest().permitAll();
   }

   @Override
   public void configure(WebSecurity web) throws Exception{
     web.debug(true);
   }
}