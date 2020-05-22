import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.ResourceLoader;
import java.util.Properties;

private String fileLocator;
private Properties prop;
private ResourceLoader resourceLoader;

 public void init() throws IOException {
        //"fileLocator" must be set as a path of file.
        final Resource resource = resourceLoader.getResource(fileLocator);

        prop = PropertiesLoaderUtils.loadProperties(resource);
    }