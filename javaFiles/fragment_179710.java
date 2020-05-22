import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class MyApplication extends Application {

  @Override
  public Set<Object> getSingletons() {
    Set<Object> s = new HashSet<Object>();

    s.add(new JacksonJsonProvider());
    s.add(new SecurityExceptionMapper());

    return s;
  }
}