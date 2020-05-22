public boolean overlaps(final LocalTimeInterval localInterval)
{
    if (localInterval.isEndOfDay())
    {
        if (isEndOfDay())
        {
            return true;
        }
        return getEnd().isAfter(localInterval.getStart());
    }
    if (isEndOfDay())
    {
        return localInterval.getEnd().isAfter(getStart());
    }
    return localInterval.getEnd().isAfter(getStart()) && localInterval.getStart().isBefore(getEnd());
}