// Silly hack to keep gigaspaces from STEALING ALL OUR LOGS
static {
    System.setSecurityManager(new SecurityManager() {
        @Override
        public void checkPermission(Permission p) {
            if (p instanceof LoggingPermission) {
                for (StackTraceElement stackTraceElement : new Exception().getStackTrace()) {
                    if (stackTraceElement.getMethodName().equalsIgnoreCase("reset") && stackTraceElement.getClassName().equalsIgnoreCase("java.util.logging.LogManager")) {
                        throw new SecurityException("No resetting the logger!  It is forbidden.");
                    }
                }
            }
        }
    });
}