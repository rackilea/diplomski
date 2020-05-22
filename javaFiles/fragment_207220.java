public Interval toInterval(final ReadableInstant baseInstant)
{
    final DateTime start = getStart().toDateTime(baseInstant);
    DateTime end = getEnd().toDateTime(baseInstant);
    if (isEndOfDay())
    {
        end = end.plusDays(1);
    }
    return new Interval(start, end);
}