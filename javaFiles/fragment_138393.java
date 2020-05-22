// Better keep this map encapsulated
private final Map<String, Range<Long>> metricRanges = new HashMap<>();

private final Comparator<Range<Long>> comparator = 
                   Comparator.nullsFirst(Comparator.comparing(Range::upperEndpoint));

static {
    // Fill in your map with default ranges
}

public void setRange(String metric, Range<Long> newRange) {
    Range<Long> oldRange = metricRanges.get(metric);
    if (comparator.compare(newRange, oldRange) > 0) {
        metricRanges.put(metric, newRange);
    }
}

public Range<Long> getRange(String metric) {
    return metricRanges.get(metric);
}