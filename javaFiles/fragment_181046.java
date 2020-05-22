String input = "12:14:02";
ReadWritablePeriod period = new MutablePeriod();
new PeriodFormatterBuilder()
        .appendHours().appendSeparator(":")
        .appendMinutes().appendSeparator(":")
        .appendSeconds().toParser().parseInto(period, input, 0, null);

Duration duration = period.toPeriod().toStandardDuration();