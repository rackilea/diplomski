try {
    executable.execute();
}
catch (Throwable actualException)
    if (expectedType.isInstance(actualException)) {
        return (T) actualException;
    }
    else {
        BlacklistedExceptions.rethrowIfBlacklisted(actualException);
        String message = buildPrefix(nullSafeGet(messageOrSupplier))
                + format(expectedType, actualException.getClass(), "Unexpected exception type thrown");
        throw new AssertionFailedError(message, actualException);
    }
}