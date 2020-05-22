...
    final Time startTime = (Time) Hibernate.TIME.nullSafeGet(resultSet, names[0]);
    final Time endTime = (Time) Hibernate.TIME.nullSafeGet(resultSet, names[1]);
    ...
    final LocalTime start = new LocalTime(startTime, DateTimeZone.UTC);
    if (endTime.equals(TIME_2400))
    {
        return new LocalTimeInterval(start, LocalTime.MIDNIGHT, true);
    }
    return new LocalTimeInterval(start, new LocalTime(endTime, DateTimeZone.UTC));