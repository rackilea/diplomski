// wrong
public static void throwRuntimeException() throws RuntimeException {
    throw new RuntimeException();
}

// correct, but dangerous
public static RuntimeException createRuntimeException() {
    return new RuntimeException();
}

public static void main(String[] args) {
    String initializeMeOrThrowException;
    if (new Random().nextBoolean()) {
        // compiler doesn't recognize that the method always throws an exception 
        throwRuntimeException();

        // this the compiler can understand, there is an explicit throw here:
        // throw createRuntimeException();

        // but this is the pitfall, it doesn't do anything:
        // createRuntimeException();
    } else {
        initializeMeOrThrowException = "Initialized!";
    }

    // Compiler error for throwRuntimeException and createRuntimeException without throws:
    // "The local variable initializeMeOrThrowException may not have been initialized"
    System.out.println(initializeMeOrThrowException); 
}