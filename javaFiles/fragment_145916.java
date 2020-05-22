final PeriodFormatter periodFormatter = new PeriodFormatterBuilder()
            .printZeroNever()
            .appendDays().appendSuffix("d")
            .appendHours().appendSuffix("h")
            .appendMinutes().appendSuffix("m")
            .appendSeconds().appendSuffix("s").toFormatter();

    org.joda.time.Duration myduration = periodFormatter.parsePeriod("1d1s").toStandardDuration(); 

    java.time.Duration dur = java.time.Duration.ofMillis(myduration.getMillis());