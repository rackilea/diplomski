public class MyInvocationHandler implements InvocationHandler {
    private MyEjb obj;
    private Class lookupClass;

    public MyInvocationHandler(MyEjb obj, Class lookupClass) {
        this.obj = obj;
        this.lookupClass = lookupClass;
    }

    public Object invoke (...) {
        try {
            return method.invoke(impl, args);
        } catch (final InvocationTargetException e) {
            if (e.getTargetException() instanceof NoSuchEJBException) {
                // 1. look up EJB again
                // 2. try calling invoke again                    
            }
        }
    }
}