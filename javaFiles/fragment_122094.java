import org.jboss.seam.contexts.Lifecycle;

@Service
public class MyService extends DefaultTimedService implements TimedObject, DefaultServiceInterface {
    @Timeout
    public void ejbTimeout(Timer timer) {
        Lifecycle.beginCall();

        MyInterface loader = (MyInterface) Component.getInstance(MyInterface.SEAM_NAME, true);
        // will not throw no context!
        // also the Component.getInstance(MyInterface.SEAM_NAME, true,true); call
        // is another way you could inject that component. 

        Lifecycle.endCall();
    }
}