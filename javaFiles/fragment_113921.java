try {
    /* ... */
} catch (IllegalAccessException | InvocationTargetException 
        | NoSuchMethodException | NoSuchFieldException e) {

    Throwable cause = e.getCause();

    if (cause instanceof CustomException) {
        throw (CustomException) cause;
    }

    throw new IllegalArgumentException();
}