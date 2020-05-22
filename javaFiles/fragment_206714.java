private Method findBestExceptionHandlerMethod(Object handler, final Exception thrownException) {
    ...
    Map<Class<? extends Throwable>, Method> handlers = exceptionHandlerCache.get(handlerType);

    if (handlers != null) {
        handlerMethod = handlers.get(thrownExceptionType); // 1
        if (handlerMethod != null) {
            return (handlerMethod == NO_METHOD_FOUND ? null : handlerMethod);
        }
    }
    ...
    final Map<Class<? extends Throwable>, Method> resolverMethods = handlers;   
    ...
    handlerMethod = getBestMatchingMethod(resolverMethods, thrownException); // 2
    handlers.put(thrownExceptionType, (handlerMethod == null ? NO_METHOD_FOUND : handlerMethod));
    return handlerMethod;
}

private Method getBestMatchingMethod(
        Map<Class<? extends Throwable>, Method> resolverMethods, Exception thrownException) {

    if (!resolverMethods.isEmpty()) {
        Class<? extends Throwable> closestMatch =
                ExceptionDepthComparator.findClosestMatch(resolverMethods.keySet(), thrownException);
        return resolverMethods.get(closestMatch);
    }
    else {
        return null;
    }
}