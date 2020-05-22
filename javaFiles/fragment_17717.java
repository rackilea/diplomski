public <T extends RecordReader<TypedBytesWritable, TypedBytesWritable>> T getRecordReader(InputSplit split, JobConf job, Reporter reporter) {

    if (!(split instanceof MongoInputSplit))
        throw new IllegalStateException("Creation of a new RecordReader requires a MongoInputSplit instance.");

    final MongoInputSplit mis = (MongoInputSplit) split;

    return new TypedBytesMongoRecordReader(mis); // you may need a cast (T) - try it without first
}