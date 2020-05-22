public class BatchInvocationHandler implements InvocationHandler {

    private final ExternalClass ext;

    public BatchInvocationHandler(ExternalClass ext) {
        this.ext = ext;
    }

    @Override
    public Object invoke(Object proxy, final Method method, final Object[] args) throws Throwable {
        return MethodUtils.invokeMethod(ext, method.getName(), args);
    }

}