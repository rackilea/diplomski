/**
     * Bind the given RequestAttributes to the current thread.
     * @param attributes the RequestAttributes to expose,
     * or {@code null} to reset the thread-bound context
     * @param inheritable whether to expose the RequestAttributes as inheritable
     * for child threads (using an {@link InheritableThreadLocal})
     */
    public static void setRequestAttributes(RequestAttributes attributes, boolean inheritable) {}