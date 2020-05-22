public class InvocationHandlerImpl implements InvocationHandler
{
    CopySoap port;

    public InvocationHandlerImpl(CopySoap copySoap) {
        port = copySoap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(port, args);
    }

}