private boolean isConstraintViolationException(Throwable throwable) {
    Throwable root = throwable;
    while (root != null && !(root instanceof ConstraintViolationException)) {
        root = root.getCause();
    }
    return root != null;
}