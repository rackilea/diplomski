@Override
protected void sendBuffer() {
    final Thread thread = Thread.currentThread();
    ClassLoader ccl = null;
    try {
        ccl = thread.getContextClassLoader();
        thread.setContextClassLoader(
                javax.mail.Transport.class.getClassLoader());
    } catch (SecurityException ignore) {
    }
    try {
        super.sendBuffer();
    } finally {
        try {
            thread.getContextClassLoader();
            thread.setContextClassLoader(ccl);
        } catch (SecurityException ignore) {
        }
    }
}