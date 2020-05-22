@Configuration
public class MyMimeMapper implements EmbeddedServletContainerCustomizer {
  @Override
  public void customize(ConfigurableEmbeddedServletContainer container) {
    MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
    mappings.add("xsd", "text/xml; charset=utf-8");
    container.setMimeMappings(mappings);
  }
}