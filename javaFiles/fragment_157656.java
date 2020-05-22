Thread currentThread = Thread.currentThread();
ClassLoader previousCL = currentThread.getContextClassLoader();
try {
    currentThread.setContextClassLoader(DDSChartsControllerImpl.class.getClassLoader());
    callNextFunctionOnStacktrace();
} finally {
    // You should set the original CL back as other technology might use the TCC tricks, too
    currentThread.setContextClassLoader(previousCL);
}