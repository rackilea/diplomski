….scheduleAtFixedRate(
    new Runnable() { … } ,          // Task to be executed repeatedly, defined as a Runnable.
    millisUntilTomorrowStart ,      // Initial delay, before first execution. Use this to get close to first moment of tomorrow in UTC per our code above.
    TimeUnit.DAYS.toMillis( 1 ) ,   // Amount of time in each interval, between subsequent executions of our Runnable.
    TimeUnit.MILLISECONDS           // Unit of time intended by the numbers in previous two arguments.
)