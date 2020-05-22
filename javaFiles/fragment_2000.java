@Test
public void testRecursive() {
    A a = or(leaf(1), and(leaf(2), leaf(3)));
    assertThat(sut.getRecursive(a), equalTo(1));
}

private A leaf(int id) {
    A a = new A();
    a.setId(id);
    return a;
}

private A or(A ... ops) {
    return operation("OR", ops);
}

private A and(A ... ops) {
    return operation("AND", ops);
}

private A operation(String operation, A ... ops) {
    A a = new A();
    a.setOp(operation);
    a.setNodes(Arrays.asList(ops));
    return a;
}