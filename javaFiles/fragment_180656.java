@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    /**
     * Default constructor.
     */
    public WebSecurityConfig()
    {
        super();
        return;
    }

    @Override
    public final void configure(final WebSecurity web) throws Exception
    {
        super.configure(web);
        web.httpFirewall(new AnnotatingHttpFirewall()); // Set the custom firewall.
        return;
    }
}