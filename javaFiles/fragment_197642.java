EventBuilderHelper myEventBuilderHelper = new EventBuilderHelper() {
    public void helpBuildingEvent(EventBuilder eventBuilder) {
        eventBuilder.withMessage("Overwritten by myEventBuilderHelper!");

        Map<String, SentryInterface> ifs = eventBuilder.getEvent().getSentryInterfaces();
        if (ifs.containsKey("sentry.interfaces.Exception"))
        {
            ExceptionInterface exI = (ExceptionInterface) ifs.get("sentry.interfaces.Exception");
            for (SentryException ex: exI.getExceptions()){
                String exceptionType = ex.getExceptionClassName();
            }
        }
    }
};