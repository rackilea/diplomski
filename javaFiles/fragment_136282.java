@XmlRootElement
public class Root {

  @XmlElement(name="foo")
  privateList<Foo> foo;

  public List<Foo> getFooList() {
    return foo;
  }

  public void setFooList(List<Foo> fooList) {
    this.foo = fooList;
  }

}

@XmlType(name = "foo")
public class Foo {

  @XmlValue
  private String content;

  @Override
  public String toString() {
    return content;
  }

}