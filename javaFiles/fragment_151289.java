public class CxfFaultListenerImpl implements FaultListener{
    public boolean faultOccurred(final Exception exception,final String description,final Message message) {

        //return false to avoid standard CXF logging of exception
        return false;
    }
}