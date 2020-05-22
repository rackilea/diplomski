@ApplicationPath("/")
public class ApplicationConfig extends Application {

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, Object> getProperties() {
    final Map<String, Object> properties = new HashMap<String, Object>();
    properties.put("jersey.config.server.disableMoxyJson", true);

    return properties;
  }
}