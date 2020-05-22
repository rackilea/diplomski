try {
    return joinPoint.proceed();
} catch (Throwable t) {
    throw new RuntimeException(t);
} finally {
    //some more code here
}