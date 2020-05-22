@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public void a()
{
    System.out.println("+++ a()");
    System.out.println("TX status is " + getTXStatus());
    // Direct invocation is treated as POJMC (plain old java method call 
    b();
    // Indirect invocation via EJB context
    HelloWorldLocal thisBean = ctx.getBusinessObject(HelloWorldLocal.class);
    thisBean.b();
    System.out.println("TX status is " + getTXStatus());
    System.out.println("--- a()");
}