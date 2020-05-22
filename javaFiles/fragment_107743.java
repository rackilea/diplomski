@Override
public void configure(JobConf conf) {
  numFiles = conf.getInt("outputs.per.reducer", 1);
  multipleOutputs = new MultipleOutputs(conf);

  // other init stuff
  ...
}

@Override
public void reduce(YourKey key
                   Iterator<YourValue> valuesIter,
                   OutputCollector<OutKey, OutVal> ignoreThis,
                   Reporter reporter) {
    // Do your business logic just as you're doing currently.
    OutKey outputKey = ...;
    OutVal outputVal = ...;

    // Now this is where it gets interesting. Hash the value to find
    // which output file the data should be written to. Don't use the
    // key since all the data will be written to one file if the number
    // of reducers is a multiple of numFiles.
    int fileIndex = (outputVal.hashCode() & Integer.MAX_VALUE) % numFiles;

    // Now use multiple outputs to actually write the data.
    // This will create output files named: multi_0-r-00000, multi_1-r-00000,
    // multi_2-r-00000, multi_3-r-00000 for reducer 0. For reducer 1, the files
    // will be multi_0-r-00001, multi_1-r-00001, multi_2-r-00001, multi_3-r-00001.
    multipleOutputs.getCollector("multi", Integer.toString(fileIndex), reporter)
      .collect(outputKey, outputValue);
}

@Overrider
public void close() {
   // You must do this!!!!
   multipleOutputs.close();
}