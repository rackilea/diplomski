public class MyTag extends TagSupport {
  private static MyObject myObject;

  @Autowired
  public void setMyObject(MyObject myObject) {
    MyTag.myObject = myObject;
  }

  public int doEndTag() {
    return object.doStuff();
  }