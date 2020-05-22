private final String foo;


public MyEntityA(int id, String name, String foo) {
    super(id, name);

    this.foo = foo;
}

public String getFoo() {
    return this.foo;
}

@Override
protected void someAbstractMethods() {
    // Some code
}