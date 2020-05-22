long futureTime = System.currentTimeMillis + yourInterval;
private void pollForStatus() throws InterruptedException {

    if (state.equals("running")) {
        log.debug("Task still running, Polling again ..");
        TimeUnit.SECONDS.sleep(1);

        //havnt reached cut off time yet, loop again
        if(System.currentTimeMilis() < futureTime){
            pollForStatus();
        }
    } else if (state.equals("complete")) {
        return;
    } else if (state.equals("stopped")) {

        // Report error state

    }


}