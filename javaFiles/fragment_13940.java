public class Builder {
  private Object optionalObj = null;
  // ...

  public Builder setObject(Object setOnce) {
    checkState(optionalObj == null, "Don't call setObject() more than once");
    optionalObj = setOnce;
  }
  // ...
}