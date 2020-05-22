try {
    getResourceA();
} catch (HystrixRuntimeException e) {
    if (e.getCause() instanceof MyException) {
        handleException((MyException)e.getCause());
    }
}