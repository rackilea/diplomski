LocalDateTime release = LocalDateTime.now()
            .with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY))
            .withHour(10)
            .withMinute(59);

Duration duration = Duration.between(LocalDateTime.now(), release);
TimeUnit.MILLISECONDS.sleep(duration.toMillis());