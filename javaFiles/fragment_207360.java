long numberOfDays = 5L;
if (attr.creationTime().toInstant().isBefore(
        Instant.now().minus(numberOfDays, ChronoUnit.DAYS)
    )
) {
    // do something
}