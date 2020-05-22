PeriodType type = PeriodType.forFields(new DurationFieldType[] {
                                           DurationFieldType.days(),
                                           DurationFieldType.minutes()
                                       });

Period period = new Period(currentDate, date, type);
// Now you'll just have minutes and days