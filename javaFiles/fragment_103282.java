try {
    return joinPoint.proceed();
} catch (Throwable t) {
    throw new JoinPointException(t);
} finally {
    //some more code here
}