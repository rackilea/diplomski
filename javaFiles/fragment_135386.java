ICalendar ical = new ICalendar();
VEvent event = new VEvent();
event.setStatus(Status.cancelled());
event.setUid(...);    //the UID of the existing event
event.setSequence(2); //increment the sequence number of the existing event
ical.addEvent(event);