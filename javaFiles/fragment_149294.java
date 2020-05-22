class TestedClass {
  OtherClass other;
  public TestedClass() { ... }
  public void setOther(OtherClass other) {
    this.other = other;
  }
  public void someMethod(ParamClass param) {
    ...
    other.otherMethod(param);
    ...
  }
}

...

class TestClass {
  @Test
  public void test() {
    TestedClass tested = new TestedClass();
    ParamClass testParam = ...
    OtherClass other = createMock(OtherClass.class);
    Capture<ParamClass> capture = new Capture<ParamClass>();
    other.otherMethod(capture);
    replay(other);
    tested.setOther(other);

    tested.someMethod(testParam);

    verify(other);
    assertThat(capture.getValue(), is(testParam));
  }
}