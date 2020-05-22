@Override
public RecordReader<LongWritable, Text> createRecordReader(
    InputSplit split, 
    TaskAttemptContext context) {

    if (backend == null) {
        logger.info("Unable to create a MyRecordReader, " + 
                    "it seems the environment was not properly set");
        return null;
    }

    // create a record reader
    return new MyRecordReader(backend, split, context);
}