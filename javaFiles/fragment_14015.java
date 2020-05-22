private NullWritable nullWritableKey = NullWritable.get();
private Text outputValue = new Text();

private StringBuilder buildOutputValue(IntWritable key,
        StringBuilder reduceValueBuilder, Text value) {
    return reduceValueBuilder.append(value);
}

@Override
public void reduce(IntWritable key, Iterable<Text> values, Context context)
        throws IOException, InterruptedException {
    Iterator<Text> valueIter = values.iterator();
    StringBuilder reduceValueBuilder = new StringBuilder();
    while (valueIter.hasNext()) {
        buildOutputValue(key, valueIter.next(), reduceValueBuilder);
        if (valueIter.hasNext()) {
            reduceValueBuilder.append("\n");
        }
    }
    context.write(NullWritable.get(), new Text(reduceValueBuilder.toString()));
}