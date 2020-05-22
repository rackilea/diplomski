Period p = Period.between ( start.toLocalDate () , stop.toLocalDate () ).minusDays ( 1 );  // Subtract one, as we account for hours of first day.

// Get the Duration of first day's hours-minutes-seconds.
LocalDateTime startNextDay = start.toLocalDate ().plusDays ( 1 ).atStartOfDay ();
Duration dStart = Duration.between ( start , startNextDay );

// Get the Duration of first day's hours-minutes-seconds.
LocalDateTime stopStartOfDay = stop.toLocalDate ().atStartOfDay ();
Duration dStop = Duration.between ( stopStartOfDay , stop );

// Combine the pair of partial days into a single Duration.
Duration d = dStart.plus ( dStop );