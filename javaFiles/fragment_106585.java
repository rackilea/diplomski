import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
....
@org.springframework.context.annotation.PropertySource("classpath:myproperty-file-.properties")
public class MyBaseClass {
    @Autowired
    private Environment environment;
...
Map<String, String> myMap= new HashMap<String, String>();
    for (PropertySource<?> propertySource : ((ConfigurableEnvironment) environment).getPropertySources()) {
                            if (propertySource instanceof EnumerablePropertySource) {
                                for (String key : ((EnumerablePropertySource) propertySource).getPropertyNames()) {
                                    if (key.startsWith("search")) {
                                        myMap.put(key.replace("search.myprop.", ""), propertySource.getProperty(key).toString());
                                    }
                                }
                            }
                        }