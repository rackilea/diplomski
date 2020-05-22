@ApplicationScoped
public MyBean {

  @Produces //this will produce @Dependent
  public Foo produceDependent() {
    return new Foo();
  }

  @Produces
  @RequestScoped //produces the scope you define
  public Bar produceReqScopedBean() {
    return new Bar();
  }
}