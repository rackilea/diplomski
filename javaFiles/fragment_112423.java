public void method1(final Properties properties) throws SomeCustomException {
    try {
        .... // do whatever
    } catch (AException | BException | CException e) {
        throw new SomeCustomException(e);
    }
}