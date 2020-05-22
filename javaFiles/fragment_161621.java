public class ApplicationListener {

    private static Class<?> nativeClass;

    static Class<?> getNativeClass() {
        try {
            if (ApplicationListener.nativeClass == null) {
                ApplicationListener.nativeClass = Class.forName("com.apple.eawt.ApplicationListener");
            }

            return ApplicationListener.nativeClass;
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("This system does not support the Apple EAWT!", ex);
        }
    }

    private Object nativeObject;

    public ApplicationListener() {
        Class<?> nativeClass = ApplicationListener.getNativeClass();

        this.nativeObject = Proxy.newProxyInstance(nativeClass.getClassLoader(), new Class<?>[] {
            nativeClass
        }, new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();

                ApplicationEvent event = new ApplicationEvent(args[0]);

                if (methodName.equals("handleReOpenApplication")) {
                    ApplicationListener.this.handleReOpenApplication(event);
                } else if (methodName.equals("handleQuit")) {
                    ApplicationListener.this.handleQuit(event);
                } else if (methodName.equals("handlePrintFile")) {
                    ApplicationListener.this.handlePrintFile(event);
                } else if (methodName.equals("handlePreferences")) {
                    ApplicationListener.this.handlePreferences(event);
                } else if (methodName.equals("handleOpenFile")) {
                    ApplicationListener.this.handleOpenFile(event);
                } else if (methodName.equals("handleOpenApplication")) {
                    ApplicationListener.this.handleOpenApplication(event);
                } else if (methodName.equals("handleAbout")) {
                    ApplicationListener.this.handleAbout(event);
                }

                return null;
            }

        });
    }

    Object getNativeObject() {
        return this.nativeObject;
    }

    // followed by abstract definitions of all handle...(ApplicationEvent) methods

}