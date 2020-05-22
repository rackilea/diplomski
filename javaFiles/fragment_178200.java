StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
System.setSecurityManager(new SecurityManager() {
    public void checkPermission(Permission permission) {
        Class<?> caller = walker.getCallerClass();
        ClassLoader ccl = caller.getClassLoader();
        if (ccl != null || ccl != getClass().getClassLoader()) {
            throw new SecurityException("You do not have permissions.");
        }
    }
});