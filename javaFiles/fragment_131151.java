FooParameters parameters = new FooParameters()
    .setName("some name")
    .setDescription("some description");

// Either a constructor call at the end, or give FooParameters
// a build() or create() method
Foo foo = new Foo(parameters);