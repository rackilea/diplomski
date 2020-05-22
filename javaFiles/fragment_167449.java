public class SpecificMethodInterceptor{

@EJB
MyCustomization myCustomization;

@AroundInvoke
public Object intercept(InvocationContext ctx) throws Exception {

    Object result = myCustomization.specificMethod((Param1Type)ctx.getParameters()[0], (Param2Type) ctx.getParameters()[1]);
    return result;
}