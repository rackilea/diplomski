@Override
public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
    Map<String, Integer> fileToCnt = new HashMap<String, Integer>();
    while(values.hasNext()) {
        String file = values.next().toString();
        Integer current = fileToCnt.get(file);
        if (current == null) {
            current = 0;
        }
        fileToCnt.put(file, current + 1);
    }
    boolean isfirst = true;
    StringBuilder toReturn = new StringBuilder();
    for (Map.Entry<String, Integer> entry : fileToCnt.entrySet()) {
        if (!isfirst) {
            toReturn.append(", ");
        }
        isfirst = false;
        toReturn.append(entry.getKey()).append(":").append(entry.getValue());
    }
    output.collect(key, new Text(toReturn.toString()));
}