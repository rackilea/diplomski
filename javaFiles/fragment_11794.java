@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addArgumentResolvers(List< Handlermethodargumentresolver > argumentResolvers) {
        MyRequestFooResolver myRequestFooResolver = new MyRequestFooResolver ();
        argumentResolvers.add(myRequestFooResolver );
  }
}