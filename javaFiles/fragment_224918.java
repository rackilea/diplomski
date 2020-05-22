protected String methodA() throws ExceptionE2 {
try {
    methodC1();
} catch (ExceptionE e) {
    throw new ExceptionE2();      // HERE
} finally {
    try {
        methodC2();
    } catch (ExceptionE e) {
        throw new ExceptionE2();  // THERE
    }
}