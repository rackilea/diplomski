public class MyValidationEventHandler implements ValidationEventHandler {

    @Override
    public boolean handleEvent(ValidationEvent event) {

        switch (event.getSeverity()) {

            case ValidationEvent.WARNING: 
            case ValidationEvent.ERROR: 
            case ValidationEvent.FATAL_ERROR: {
                log.error("Validation event : {} in {} line {} col {}",
                          event.getMessage(),
                          event.getLocator().getURL(),
                          event.getLocator().getLineNumber(),
                          event.getLocator().getColumnNumber());
                return false;
            }
            default:
                return true;
        }
    }
}