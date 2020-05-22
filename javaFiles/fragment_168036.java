public class ValidationInterceptor extends AbstractPhaseInterceptor<Message> {


    public ValidationInterceptor() {
        super(Phase.READ);
    }

    public void handleMessage(Message message) throws Fault {
        message.setContextualProperty("jaxb-validation-event-handler", new MyValidationEventHandler());

    }

}