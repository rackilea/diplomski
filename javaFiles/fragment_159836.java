@Configuration
@EnableWebSecurity
public class CacheControlAdapter extends WebSecurityConfigurerAdapter {
  public CacheControlAdapter() {}

  @Override
  @RequestMapping("/app/")
  protected void configure(HttpSecurity http) throws Exception {
    StaticHeadersWriter writer = new StaticHeadersWriter("Cache-Control", "value");
    http
      .headers()
      .cacheControl()
      .disable()
      .addHeaderWriter(writer);
  }
}