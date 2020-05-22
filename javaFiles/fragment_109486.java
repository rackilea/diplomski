@ConfigurationProperties(prefix="my")
public class ConfigBinder {

    private String name;

    private String url; // expected to be filled automatically

    public String getUrl() {
        return this.url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}