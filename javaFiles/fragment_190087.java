File file = EasyMock.createNiceMock(File.class);

private MyClass createMyClass() {
  return new MyClass() {
    @Override protected File OpenFile(String fileName) { return file; }
  };
}

@Test public testFoo() {
  EasyMock.expect(file.exists()).andStubReturn(true);
  //...
  MyClass myClass=createMyClass();
  // ...
}