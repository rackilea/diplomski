@XmlRootElement public static class A {
  public List<B> b = new ArrayList<B>();
}

public static class B {
  public List<C> c = new ArrayList<C>();
  @XmlAttribute(name = "attribute-foo") public String attributeFoo = "foo";
}

public static class C {
  @XmlAttribute(name = "attribute-this") public String attributeThis = "is";
}

public static void main(String[] args) {
  A a = new A();
  a.b.add(new B());
  a.b.get(0).c.add(new C());
  JAXB.marshal(a, System.out);
}
//TODO: getters/setters, error handling and so on