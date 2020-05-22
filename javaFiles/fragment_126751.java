public class ObjectWrapper {
  @SerializedName("myobject")
  public final MyObject myObject;

  public ObjectWrapper(MyObject myObject) {
    this.myObject = myObject;
  }
}