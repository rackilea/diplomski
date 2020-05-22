// register a provider for your custom genson configuration.
@Provider
public class GensonCustomResolver implements ContextResolver<Genson> {
  // configure the Genson instance
  private final Genson genson = new Genson.Builder()
                                        // if you want to support JAXB annotations
                                        .with(new JAXBBundle())
                                        .setSkipNull(true)
                                        .create();

  @Override
  public Genson getContext(Class<?> type) {
    return genson;
  }
}