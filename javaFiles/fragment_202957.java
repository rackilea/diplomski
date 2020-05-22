/**
 * Refresh {@link DispatcherServlet}
 * @return true if refreshed, false if not
 * @throws RuntimeException
 */
private static boolean refreshDispatcherServlet() throws RuntimeException {
    if (dispatcherServlet != null) {
        dispatcherServlet.refresh();
        return true;
    }

    return false;
}

/**
 * Refresh the given {@link XmlWebApplicationContext}.<br>
 * Call {@link Module#onStarted()} after context refreshed.<br>
 * Unload started modules on {@link RuntimeException}.
 * @param context Application context
 * @param startedModules Started modules
 * @throws RuntimeException
 */
public static void refreshContext(XmlWebApplicationContext context, Module[] startedModules) throws RuntimeException {
    try {
        logger.debug("Closing web application context");
        context.stop();
        context.close();

        AppClassLoader.destroyInstance();

        setCurrentClassLoader(context);

        logger.debug("Refreshing web application context");
        context.refresh();

        setCurrentClassLoader(context);

        AppClassLoader.setThreadsToNewClassLoader();

        refreshDispatcherServlet();

        if (startedModules != null) {
            for (Module module : startedModules) {
                module.onStarted();
            }
        }
    }
    catch (RuntimeException e) {
        for (Module module : startedModules) {
            try {
                ModuleManager.stopModule(module.getId());
            }
            catch (IOException e2) {
                e.printStackTrace();
            }
        }

        throw e;
    }
}

/**
 * Set the current classloader to the {@link XmlWebApplicationContext} and {@link Thread#currentThread()}.
 * @param context ApplicationContext
 */
public static void setCurrentClassLoader(XmlWebApplicationContext context) {
    context.setClassLoader(AppClassLoader.getInstance());
    Thread.currentThread().setContextClassLoader(AppClassLoader.getInstance());
}