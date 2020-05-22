java.time.LocalDateTime java8LocalDateTime = java.time.LocalDateTime.now();

// Separate steps, showing intermediate types
java.time.ZonedDateTime java8ZonedDateTime = java8LocalDateTime.atZone(ZoneId.systemDefault());
java.time.Instant java8Instant = java8ZonedDateTime.toInstant();
long millis = java8Instant.toEpochMilli();
org.joda.time.LocalDateTime jodaLocalDateTime = new org.joda.time.LocalDateTime(millis);

// Chained
org.joda.time.LocalDateTime jodaLocalDateTime =
        new org.joda.time.LocalDateTime(
            java8LocalDateTime.atZone(ZoneId.systemDefault())
                              .toInstant()
                              .toEpochMilli()
        );

// One-liner
org.joda.time.LocalDateTime jodaLocalDateTime = new org.joda.time.LocalDateTime(java8LocalDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());