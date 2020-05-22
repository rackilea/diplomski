public enum MyEnum {
  FOO, BAR;
}

public class Foo extends RealmObject {
  private String enumDescription;

  public void saveEnum(MyEnum val) {
    this.enumDescription = val.toString();
  }

  public MyEnum getEnum() {
    return MyEnum.valueOf(enumDescription);
  }
}