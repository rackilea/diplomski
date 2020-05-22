final DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
    final DateFormat dateFormat2 = new SimpleDateFormat(...);
    java.util.Date startDate = null;
    try {
        startDate = dateFormat.parse(session.getStartTime__c());
        startTime = new Time(startDate.getTime());
    } catch (ParseException e) {
       try {
         startDate = dateFormat2.parse(session.getStartTime__c());
       } catch (ParseException e) {
        LOG.error(e.getMessage(), e);
       }
    }   // try