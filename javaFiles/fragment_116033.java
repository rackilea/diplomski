allowing(mockedObject).f();
will(new CustomAction("Returns new BusinessObj instance") {
  @Override
  public Object invoke(Invocation invocation) throws Throwable {
    return new BusinessObj();
  }
});