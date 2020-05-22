public abstract class FunCache {
  public String getValue() {
    String result = cacheFun();
    if (result == null) {
      result = diskFun();
    }
    return result;
  }

  abstract public String cacheFun();
  abstract public String diskFun();
}

class FirstImplementation extends FunCache {
  public String cacheFun() {
    // implementation!
  }

  public String diskFun() {
    // implementation!
  }
}

// some other code that wants to use it
FunCache fc = new FirstImplementation();
String value = fc.getValue();