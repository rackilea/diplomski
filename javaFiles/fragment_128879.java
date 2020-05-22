public void reduce(Text key, Iterable<TextLongWritable> values,Context context) throws IOException, InterruptedException {

    long word1count = 0;
    List<TextLongWritable> cache = new ArrayList<TextLongWritable>();

    String decade = key.toString().split("\t")[0];
    String word1 = key.toString().split("\t")[1];

    for (TextLongWritable val : values) {
        if (val.getWord().equals("*")){
            word1count += val.getCount();
            continue;
        }
        TextLongWritable val_copy = new TextLongWritable(val.getWord(),val.getCount());
        cache.add(val_copy);
    }

    context.write(key, new Text("" + word1count));

    for (TextLongWritable value : cache) {
        context.write(new Text(decade + "\t" + value.getWord()), new Text(word1 + " " + value.getCount() + "\t" + word1count));
    }
}