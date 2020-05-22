JavaPairRDD<LongWritable, Text> javaPairRDD = sc.newAPIHadoopFile(
    "hdfs://path/*.csv", 
    TextInputFormat.class, 
    LongWritable.class, 
    Text.class, 
    new Configuration()
);
JavaNewHadoopRDD<LongWritable, Text> hadoopRDD = (JavaNewHadoopRDD) javaPairRDD;

JavaRDD<Tuple2<String, String>> namedLinesRDD = hadoopRDD.mapPartitionsWithInputSplit((inputSplit, lines) -> {
    FileSplit fileSplit = (FileSplit) inputSplit;
    String fileName = fileSplit.getPath().getName();

    Stream<Tuple2<String, String>> stream =
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(lines, Spliterator.ORDERED), false)
            .map(line -> {
                String lineText = line._2().toString();
                // emit file name as key and line as a value
                return new Tuple2(fileName, lineText);
            });
    return stream.iterator();
}, true);