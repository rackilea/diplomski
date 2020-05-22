public abstract class AProcess extends Process {

    private String name;
    private Properties properties;
    public AProcess(String name, Properties properties)
    {
        this.setName(name);
        this.setProperties(properties);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}