Calendar cal = Calendar.getInstance();
    String  emailTemplateId = ""; //some value
    Calendar  boundaryTime = Calendar.getInstance();
    boundaryTime.set(Calendar.HOUR_OF_DAY,17);
    boundaryTime.set(Calendar.MINUTE,30);
    boundaryTime.set(Calendar.SECOND,0);
    boundaryTime.set(Calendar.MILLISECOND,0);


    if( "342856".equals(emailTemplateId) && cal.getTime().before(boundaryTime.getTime()))  {
        tmp_disp.setScheduledDate(boundaryTime.getTime());
            LOGGER.debug(">>> ScheduledDate: " + tmp_disp.getScheduledDate());
     }
    else {
        tmp_disp.setScheduledDate(null);
        LOGGER.debug(">>> ScheduledDate: " + tmp_disp.getScheduledDate());