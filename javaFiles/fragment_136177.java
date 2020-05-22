@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "zuul")
public class CustomPathZuulFilterConfig {

    private List<String> groovyFiltersPath;

    public List<String> getGroovyFiltersPath() {
        return groovyFiltersPath;
    }

    public void setGroovyFiltersPath(List<String> groovyFiltersPath) {
        this.groovyFiltersPath = groovyFiltersPath;
    }
}