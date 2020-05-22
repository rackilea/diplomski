// fields used by the period - use only months and days
PeriodType fields = PeriodType.forFields(new DurationFieldType[] {
        DurationFieldType.months(), DurationFieldType.days()
    });
Period period = new Period(dateOfBirth, endDate)
    // normalize to months and days
    .normalizedStandard(fields);