public static class MyPeriodicTask implements Runnable {

    public void run() {
        boolean fullHour = ... // determine somehow
        if (fullHour) {
            Platform.runLater(new Runnable() {

                public void run() {
                    // Modify label here
                }
            });
        }
    }
}