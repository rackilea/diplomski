public void delayTestsbyMillis(int millis) {
    try {
        if(millis < 59000)
            Thread.sleep(millis);
        else {
            int numLoop = millis/50000;
            for(int i = 0; i < numLoop; i++){
                Thread.sleep(50000);
                onView(withId(R.id.rolling_news)).perform(click());
            }
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}