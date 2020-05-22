@Override
 public void run() {
    try {  // Let no Exception reach the ScheduledExecutorService.
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Running scheduled update check " + date.toString());
        updateSubscriberService.checkForUpdates();
    } catch ( Exception e ) {
        System.out.println( "ERROR - unexpected exception" );
    }
}