private final int value;


public MyEntityB(int id, String name, int value) {
    super(id, name);

    this.value = value;
}

public int getValue() {
    return this.value;
}

@Override
protected void someAbstractMethods() {
    // Some code
}