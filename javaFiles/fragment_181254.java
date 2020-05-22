try{
    //Some code that throws an exception
    }

catch(SomeException e)
    {
    String stackTrace = ExceptionUtils.getStackTrace(e);
    log.error(":: An error has occurred :::: " + stackTrace);
    }