PCollectionTuple results = /* some transforms */

// write main result
results.get(mainOutputTag) /* PCollection<TableRow> */

    .apply(ParDo.of(new DoFn<TableRow, String>() {
        @ProcessElement
        public void processElement(ProcessContext c) {
            c.output(c.element().toString());
        }
    })) /* PCollection<String> */

    .apply("WriteProfile", TextIO.write().to(outputBucket)
    .withSuffix(".json")        
    .withWritableByteChannelFactory(FileBasedSink.CompressionType.GZIP)
    .withNumShards(numChunks));