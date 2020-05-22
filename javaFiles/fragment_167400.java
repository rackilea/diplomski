@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@ComponentScan(//...)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//...
}