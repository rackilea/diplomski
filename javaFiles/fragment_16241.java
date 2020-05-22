// the Double value
    Double someTime = 3.5;

    // two ways of converting it to Duration
    // (we need to use minutes because Duration.of expects a long, which cannot be fractional
    Duration someDuration = Duration.ofMinutes((long) (someTime * 60));
    Duration someDuration2 = Duration.of((long) (someTime * 60), ChronoUnit.MINUTES);

    // convert the duration back to Double
    Double someTimeAgain = (double)someDuration.toMinutes() / 60;