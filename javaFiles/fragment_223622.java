@Stateless
public class TestEJB implements PrivateIface, PublicIface {
    SessionContext ctx;

    public void doBusiness() {
        PrivateIface businessObject = ctx.getBusinessObject(PrivateIface.class);
        businessObject.doPrivateBusinness();
    }
    @SomeContainerAnnotation
    public void doPrivateBusinness() {

    }
}

@Local
interface PrivateIface {
    void doPrivateBusinness();
}