public class PlayFrameworkPropertySource extends PropertySource<Object> {

    public PlayFrameworkPropertySource() {
        super("Play Framework properties resolution mechanism");
    }

    @Override
    public Object getProperty(String propertyName) {
        // or ConfigFactory.load().getString(propertyName), as you prefer...
        return Configuration.root().getString(propertyName);
    }
}