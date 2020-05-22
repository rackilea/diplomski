private <T extends Throwable> void myFunc(Class<T> exceptionType) throws T {
    final String message = "some message";
    try {
        throw exceptionType.getConstructor(String.class).newInstance(message);
    } catch (InstantiationException e) {
        e.printStackTrace();
        // rethrow
    } catch (IllegalAccessException e) {
        e.printStackTrace();
        // rethrow
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
        // rethrow
    } catch (InvocationTargetException e) {
        e.printStackTrace();
        // rethrow
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
        // rethrow
    } catch (SecurityException e) {
        e.printStackTrace();
        // rethrow
    }
}