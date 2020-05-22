JavaRDD<Tuple2<String, String>> namedLinesRDD = hadoopRDD.mapPartitionsWithInputSplit(
    new Function2<InputSplit, Iterator<Tuple2<LongWritable, Text>>, Iterator<Tuple2<String, String>>>() {
        @Override
        public Iterator<Tuple2<String, String>> call(InputSplit inputSplit, final Iterator<Tuple2<LongWritable, Text>> lines) throws Exception {
            FileSplit fileSplit = (FileSplit) inputSplit;
            final String fileName = fileSplit.getPath().getName();
            return new Iterator<Tuple2<String, String>>() {
                @Override
                public boolean hasNext() {
                    return lines.hasNext();
                }
                @Override
                public Tuple2<String, String> next() {
                    Tuple2<LongWritable, Text> entry = lines.next();
                    return new Tuple2<String, String>(fileName, entry._2().toString());
                }
            };
        }
    }, 
    true
);