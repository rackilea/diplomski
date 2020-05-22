final ArgumentCaptor<Foo> captor = ArgumentCaptor.forClass(Foo.class);

verify(mock).doSomething(captor.capture());

final Foo argument = captor.getValue();

// Test the argument