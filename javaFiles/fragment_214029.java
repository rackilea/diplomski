public class CallRef extends Call {

    private Class<? extends Controller> controllerClass;
    private Method controllerMethod;

    public CallRef(Call call, Class<? extends Controller> controllerClass,
                   String controllerMethodName, Class<?>... methodArgs) throws NoSuchMethodException {

        this(call, controllerClass, controllerClass.getMethod(controllerMethodName, methodArgs));
    }

    public CallRef(Call call, Class<? extends Controller> controllerClass, Method controllerMethod) {
        this(call.method(), call.url(), call.fragment(), controllerClass, controllerMethod);
    }

    public CallRef(String method, String url, String fragment, Class<? extends Controller> controllerClass, Method controllerMethod) {
        super(method, url, fragment);
        this.controllerClass = controllerClass;
        this.controllerMethod = controllerMethod;
    }

    public CallRef(CallRef callRef){
            this(callRef, callRef.getControllerClass(), callRef.getControllerMethod());
    }

    public Class<? extends Controller> getControllerClass() {
        return controllerClass;
    }

    public Method getControllerMethod() {
        return controllerMethod;
    }
}