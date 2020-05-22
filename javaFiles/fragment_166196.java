public class HelloWorld extends UIObject {

  private static HelloWorldUiBinder uiBinder = 
        GWT.create(HelloWorldUiBinder.class);

  interface HelloWorldUiBinder extends UiBinder<Element, HelloWorld> {
  }

  @UiField
  SpanElement nameSpan;

  public HelloWorld() {
    setElement(uiBinder.createAndBindUi(this));
  }

  public void setName(String name) { 
    nameSpan.setInnerText(name); 
  }

}