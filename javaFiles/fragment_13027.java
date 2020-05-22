public void performUpdate() throws exception {
    Timer timer = null;
    try {
        // At this line a new Thread will be created
        timer = new Timer();

        try {
            timer.cancel();
        } catch (Exception e) {
            //Notify the task owner of the exception
        }
    } finally {
        if ( timer != null ) timer.close();
    }
}