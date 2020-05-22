Map<String, List<DataPoint>> metriDps = new HashMap<>();
String[] metricNames = new String[] {
        "m1", "m2", "m3"
};
List<DataPoint> dataPoints1 = new ArrayList<DataPoint>();
dataPoints1.add(new DataPoint(0, 1));
dataPoints1.add(new DataPoint(2, 1));
dataPoints1.add(new DataPoint(3, 5));
metriDps.put("m1", dataPoints1);

List<DataPoint> dataPoints2 = new ArrayList<DataPoint>();
dataPoints2.add(new DataPoint(1, 2));
dataPoints2.add(new DataPoint(2, 3));
dataPoints2.add(new DataPoint(3, 5));
metriDps.put("m2", dataPoints2);

List<DataPoint> dataPoints3 = new ArrayList<DataPoint>();
dataPoints3.add(new DataPoint(0, 2));
dataPoints3.add(new DataPoint(2, 6));
dataPoints3.add(new DataPoint(4, 5));
metriDps.put("m3", dataPoints3);

SortedMap<Long, Map<String, String>> map = new TreeMap<>();
// format:
// time1 -> [(metricName, value), (metricName, value), ..]
// time2 -> [(metricName, value), (metricName, value), ..]
// ..

metriDps.entrySet().stream()
        .forEach(entry -> {
            List<DataPoint> points = entry.getValue();
            String metric = entry.getKey();
            points.forEach(point -> {
                Long time = point.getTimestamp();
                Object value = point.getValue();
                if (value != null)
                    // add (metricName, value) to map stored under time
                    map.computeIfAbsent(time, key -> new HashMap<>())
                            .put(metric, value.toString());
            });
        });

StringWriter writer = new StringWriter();
// header
writer.append("timestamp,");
writer.append(Stream.of(metricNames).collect(Collectors.joining(",")));
writer.append('\n');
// content, sorted map means we can simply iterate it's keys
map.entrySet().forEach(entry -> {
    // time
    writer.append(String.valueOf(entry.getKey()));
    writer.append(',');
    // fetch all possible metric names from the map so it prints empty ",,"
    String line = Stream.of(metricNames)
            .map(entry.getValue()::get)
            .map(val -> val == null ? "" : val)
            .collect(Collectors.joining(","));
    writer.append(line);
    writer.append('\n');
});
System.out.println(writer);