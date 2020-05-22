public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String methodName = method.getName();
    ApplicationEvent event = new ApplicationEvent(args[0]);
    Method method = ApplicationListener.class.getMethod(methodName, ApplicationEvent.class);
    return method.invoke(ApplicationListener.this, event);
}