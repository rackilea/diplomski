@JsonInclude(Include.NON_NULL)
class Foo
{
  public String bar;

  Foo(String bar)
  {
    this.bar = bar;
  }
}