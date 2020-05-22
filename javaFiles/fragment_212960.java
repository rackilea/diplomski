private static interface ThrowingMethod<E1 extends Exception,E2 extends Exception> {
    void run() throws E1, E2;
}

public <E1 extends Exception,E2 extends Exception>
void wrapMethod(ThrowingMethod<E1,E2> method) throws E1,E2 {
    // same as before
}