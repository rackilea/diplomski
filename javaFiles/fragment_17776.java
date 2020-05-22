public class ElementImpl implements XML.Element {
  private Map<String, String> attributes;

  public ElementImpl(String name, Map<String, String> attributes) {
    this.attributes = attributes;
  }
}