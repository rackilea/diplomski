public class MyEjbProducer {
    @EJB(name = "MyEjb")
    private MyEjb obj;

    @Produces
    public MyEjb getEjb(final InjectionPoint ip) {
        InvocationHandler handler = new MyInvocationHandler(obj, MyEjb.class);
        return (MyEjb)Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}