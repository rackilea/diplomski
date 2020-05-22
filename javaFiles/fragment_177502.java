static {
    for (Example e: values()) {
        addExample(e);
    }
}

private static addExample(Example example) {
    Example prev = exampleByPropertyA.put(example.propertyA, example);
    assert prev == null;
}