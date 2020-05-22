String platformClass
            = ServerPlatformUtils.detectServerPlatform(null);
    try {
        detectedPlatform
                = ServerPlatformUtils.createServerPlatform(
                null, platformClass,
                SessionManager.class.getClassLoader());
    } catch (NullPointerException npe) {
        //some platforms may not be handling 'null' session well,
        //so be defensive here and only log throwable here
        detectedPlatform = null;
        LOG.logThrowable(SessionLog.WARNING,
                AbstractSessionLog.CONNECTION, npe);
    }