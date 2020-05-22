public boolean handleBreakpointEvent(Event event, JDIThread thread, boolean suspendVote)
    ...
    Location location = ((ExceptionEvent)event).catchLocation();
    if (location == null) {
           location = ((ExceptionEvent)event).location();
    }