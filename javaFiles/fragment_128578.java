private static JAXBContext createJAXBContext() throws Exception {
        return isJDKInternal()?(JAXBContext)AccessController.doPrivileged(new PrivilegedExceptionAction<JAXBContext>() {
            public JAXBContext run() throws Exception {
                return JAXBContext.newInstance(MetroConfig.class.getPackage().getName());
            }
        }, createSecurityContext()):JAXBContext.newInstance(MetroConfig.class.getPackage().getName());
}