private class ValidatorHandler extends DefaultValidationEventHandler {
    @Override
    public boolean handleEvent(ValidationEvent event) {
        if (event.getSeverity() == ValidationEvent.WARNING) {
            return super.handleEvent(event);
        } else if (event.getSeverity() == ValidationEvent.ERROR
                && event.getMessage().startsWith("unexpected element")) {
            return true;
        } else {
            throw new RuntimeException(event.getMessage()
                    + " [line:" + event.getLocator().getLineNumber() + "]");
        }
    }
}