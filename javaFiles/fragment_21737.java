@Override
public void onReceive(Context context, Intent i) {

    if (ActivityTransitionResult.hasResult(i)) {
        ActivityTransitionResult result = ActivityTransitionResult.extractResult(i);

        for (ActivityTransitionEvent event : result.getTransitionEvents()) {
            //continue only if the activity happened in the last 30 seconds
            //for some reason callbacks are received for old activities when the receiver is registered
            if(((SystemClock.elapsedRealtime()-(event.getElapsedRealTimeNanos()/1000000))/1000) <= 30) {
                //activity transition is legit. Do stuff here..
            }
        }
    }
}