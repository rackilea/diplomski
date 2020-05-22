/**
 * Throws a MyException.
 */
public static void methodThrowsException() throws MyException {
    throw new MyException();
}

/**
 * Calls methodThrowsException(), and handles the thrown MyException
 */
public static void myMethod() {
    try {
        methodThrowsException();
    } catch(MyException e) {
        /* Do something */
    }
}

/**
 * Calls methodThrowsException, but does not handle the thrown MyException.
 */
public static void mySecondMethod() throws MyException {
    methodThrowsException();
}