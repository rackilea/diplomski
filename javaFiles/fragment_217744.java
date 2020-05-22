public static void launch(String... args) {
    // Figure out the right class to call
    StackTraceElement[] cause = Thread.currentThread().getStackTrace();

    boolean foundThisMethod = false;
    String callingClassName = null;
    for (StackTraceElement se : cause) {
        // Skip entries until we get to the entry for this class
        String className = se.getClassName();
        String methodName = se.getMethodName();
        if (foundThisMethod) {
            callingClassName = className;
            break;
        } else if (Application.class.getName().equals(className)
                && "launch".equals(methodName)) {

            foundThisMethod = true;
        }
    }

    if (callingClassName == null) {
        throw new RuntimeException("Error: unable to determine Application class");
    }

    try {
        Class theClass = Class.forName(callingClassName, false,
                           Thread.currentThread().getContextClassLoader());
        if (Application.class.isAssignableFrom(theClass)) {
            Class<? extends Application> appClass = theClass;
            LauncherImpl.launchApplication(appClass, args);
        } else {
            throw new RuntimeException("Error: " + theClass
                    + " is not a subclass of javafx.application.Application");
        }
    } catch (RuntimeException ex) {
        throw ex;
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
}