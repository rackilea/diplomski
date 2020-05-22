public class JavascriptLink extends Label{

  public JavascriptLink(String id, String label) {
    super(id, label);
    add(new AttributeAppender("onclick", "...your javascript here..."));
  }
}