public class ProductJso extends JavaScriptObject {
  protected ProductJso() {}
  public final native int getId() /*-{ 
    return this.id;
  }-*/;
  public final native int getCategoryId() /*-{
    return this.categoryid;
  }-*/;
  public final native String getName() /*-{
    return this.name;
  }-*/;
  // And so on...
}