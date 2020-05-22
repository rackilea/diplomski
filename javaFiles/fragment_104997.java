public class Foo {
  private String bar;
  public String getBar() { return bar; }
  public void setBar(String bar) { this.bar = bar; }

  public static void main(String[] args) {
    Foo foo = new Foo();
    foo.setBar("Hello, World!");
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    JAXB.marshal(foo, out);
    foo = (Foo)
        JAXB.unmarshal(new ByteArrayInputStream(out.toByteArray()), Foo.class);
    System.out.println(foo.getBar());
  }
}