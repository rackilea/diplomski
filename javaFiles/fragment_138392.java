public void setRange(String metric, Range<Long> newRange) {
    Range<Long> oldRange = metricRanges.get(metric);
    if (comparator.compare(newRange, oldRange) > 0) {
        metricRanges.put(metric, newRange);
    }
}