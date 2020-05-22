public void reduce(Text key, Iterable<Text> values, Context context)
        throws IOException, InterruptedException {
    Map<String, Integer> files = new HashMap<String, Integer>();
    for (Text val : values) {
        if (files.containsKey(val.toString())) {
            files.put(val.toString(), files.get(val.toString()) + 1);
        } else {
            files.put(val.toString(), 1);
        }
    }

    String outputString = key.toString();

    for (String file : files.keySet()) {
        outputString += "\n( " + file + ", " + files.get(file) + ")";
    }

    context.write(key, new Text(outputString));
}