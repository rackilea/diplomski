@Test
public void testMockInvocation() {
    BaseView baseView = Mockito.mock(BaseView.class);

    Foo<String> foo = new Foo(baseView);

    String input = "some input";
    foo.onResponse(input);

    Mockito.verify(baseView).setup(input);

    int error = 1;
    foo.onError(error);

    Mockito.verify(baseView).displayError(error);
}