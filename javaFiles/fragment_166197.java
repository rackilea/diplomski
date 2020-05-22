public class HelloWorld implements EntryPoint {

  interface HelloWorldUiBinder extends UiBinder<Element, HelloWorld> {
  }

  @UiField SpanElement nameSpan;

  public void onModuleLoad() {
    final HelloWorldUiBinder uiBinder = GWT.create(HelloWorldUiBinder.class);
    final Element element = uiBinder.createAndBindUi(this);
    nameSpan.setInnerText("world");
    Document.get().getBody().appendChild(element);
  }
}