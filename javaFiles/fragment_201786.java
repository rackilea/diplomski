public class Compiler {

  private final String template;
  private final Object o;
  private final Object params;

  Compiler(String template, Object o, Object params) {
    this.template = template;
    this.o = o;
    this.params = params;
  }

  public void compile() {
    //...
    context();
    //...
  }

  private void context() {
    //...
    substitute();
    //...
  }

  private void substitute() {
    //...
    print();
    //...
  }

  private void print() {
    //...
    System.out.println(this.params);
    //...
  }
}