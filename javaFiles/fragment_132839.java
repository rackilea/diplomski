public class InvokesMethod implements InvokesMethodItf{

private Method method;

@Override
public void invokeMethod() throws Exception {
     method.invoke(null);
}

@Override
public void setMethod(Method method) {
    this.method = method;
}

}