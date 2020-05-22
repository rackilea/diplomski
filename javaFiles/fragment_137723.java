try {
    // do something...
} catch (ExceptionA | ExceptionB e) {
    if (e instanceof ExceptionA) {
        // handling for ExceptionA
    } else {
        // handling for ExceptionB
    }
    // common handling for both exception types
}