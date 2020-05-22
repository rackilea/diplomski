StringWriter writer = new StringWriter();
// header
writer.append("timestamp,");
writer.append(Stream.of(metricNames).collect(Collectors.joining(",")));
writer.append('\n');

List<NamedKeeparator> iterators = metriDps.entrySet().stream()
        .map(entry -> new NamedKeeparator(entry.getKey(), entry.getValue().iterator()))
        .collect(Collectors.toList());

List<NamedKeeparator> leastIterators = new ArrayList<>();
for (;;) {
    leastIterators.clear();
    long leastValue = Long.MAX_VALUE;
    for (NamedKeeparator iterator : iterators) {
        // advance until there is some value
        while (iterator.current() == null && iterator.hasNext()) {
            iterator.next();
        }
        // build set of iterators pointing to least value
        if (iterator.current() != null
                && iterator.current().getTimestamp() <= leastValue) {
            if (iterator.current().getTimestamp() < leastValue) {
                leastValue = iterator.current().getTimestamp();
                leastIterators.clear();
            }
            leastIterators.add(iterator);
        }
    }
    // nothing -> all iterators done
    if (leastIterators.isEmpty())
        break;

    // least contains now iterators for the same timestamp

    // get time from the first
    long time = leastIterators.get(0).current().getTimestamp();
    writer.append(String.valueOf(time)).append(',');

    // format points
    String points = Stream.of(metricNames)
            .map(metric -> leastIterators.stream()
                    .filter(it -> it.getName().equals(metric)).findAny()
                    .map(it -> it.current()).orElse(null))
            .map(point -> point != null ? String.valueOf(point.getValue()) : "")
            .collect(Collectors.joining(","));

    writer.append(points).append('\n');

    leastIterators.forEach(it -> {
        it.consume();
    });
}
System.out.println(writer);