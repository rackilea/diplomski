System.setSecurityManager(new SecurityManager() {
    public void checkPermission(Permission permission) {
        Class<?> caller = getClassContext()[1];
        ClassLoader ccl = caller.getClassLoader();
        if (ccl != null || ccl != getClass().getClassLoader()) {
            throw new SecurityException("You do not have permissions.");
        }
    }
});