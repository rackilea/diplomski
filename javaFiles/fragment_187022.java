void m() throws Exception {
    try {
        A();
    } catch (Exception e) {
        B();
        throw e;
    }
}

private void B() {
    throw new RuntimeException("No!!!!");
}

private void A() throws Exception {
    throw new RuntimeException("Do I make it??");
}