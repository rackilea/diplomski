void m() throws Exception {
    try {
        A();
    } catch (Exception e) {
        throw e;
        B();
    }
}