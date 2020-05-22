Integer foo() throws Exception {
    if (hasFoo()) {
        return getFoo();
    } else {
        throw new IOException();
    }
}