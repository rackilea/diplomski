private static Throwable findSpecificCause(Throwable throwable) {
        Throwable rootCause = getRootCause(throwable);
        return (rootCause != null ? rootCause : throwable);
    }

private static Throwable getRootCause(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        Throwable rootCause = null;
        Throwable cause = throwable.getCause();
        while (cause != null && cause != rootCause) {
            rootCause = cause;
            cause = cause.getCause();
        }
        return rootCause;
    }