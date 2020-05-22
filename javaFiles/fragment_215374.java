public static int exceptionTester(int i) throws FAException{
    try {
        if (i==0) {
            throw new FAException("some status code", "some message", null);
        }
    } catch (FAException e) {
        throw e; // <-- re-throw it. 
    }
    return i;
}