package test;

...

@XmlType(name = "test", namespace = "http://test.com", propOrder = "b")
@XmlRootElement(name = "test", namespace = "http://test.com")
public final class Test {

  @XmlAttribute(required = false)
  public String a;

  @XmlElement
  public String b;

  public Test() {}
}