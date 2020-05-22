Period period = new Period(dateTimeStart, dateTimeStop, PeriodType.forFields(
        new DurationFieldType[]{
                DurationFieldType.years(),
                DurationFieldType.months(),
                DurationFieldType.days(),
                DurationFieldType.hours(),
                DurationFieldType.minutes(),
                DurationFieldType.seconds(),
                DurationFieldType.millis(),
        }));