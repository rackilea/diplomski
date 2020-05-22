protected String methodA() throws ExceptionE2 {
    List<ExceptionE> exceptions = new ArrayList<>();
    try {
        methodC1();
    } catch (ExceptionE e) {
        exceptions.add(e);
    }
    try {
        methodC2();
    } catch (ExceptionE e) {
        exceptions.add(e);
    }
    if (!exceptions.isEmpty()) {
        throw new ExceptionE2(exceptions);
    }
}