public class SomeObject implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // Perform job during adding to the session.
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // Perform job during removal from the session.
    }

}