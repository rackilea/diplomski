OffsetDateTime now = OffsetDateTime.now( ZoneOffset.UTC ) ;  // Capture the current moment.

….scheduleAtFixedRate(
    new Runnable() { … } ,           // Define task to be executed as a `Runnable`.
    Duration.between(                // Determine amount of time for initial delay until first execution of our Runnable.
        now ,                        // Current moment.
        now.toLocalDate().plusDays( 1 ).atStartOfDay( ZoneOffset.UTC )  // Determine the first moment of tomorrow in our target time zone (UTC). Used as the exclusive end of our Half-Open span of time.
    ) ,
    TimeUnit.DAYS.toMillis( 1 ) ,    // Amount of time between subsequent executions of our Runnable. Use self-documenting code rather than a “magic number” such as `86400000`. 
    TimeUnit.MILLISECONDS            // Specify the granularity of time used in previous pair of arguments.
)                                    // Returns a `ScheduledFuture` which you may want to cache.