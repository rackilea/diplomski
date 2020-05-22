/**
     * Recursively find the ConversionFailedException
     * @param target
     * @return
     */
    public ConversionFailedException findConversionFailedException(Throwable target) {
        Throwable cause = target.getCause();
        if (cause == null) {
            return null;
        } else if (cause instanceof ConversionFailedException) {
            return (ConversionFailedException)cause;
        }
        return findConversionFailedException(target);
    }