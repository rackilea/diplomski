protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException
      try {
          XMLStreamReader reader = ...
          context.write(...);
      } catch(XMLStreamException e){
            // do nothing
            context.getCounter(INVALID_RECORDS).increment(1);
      }
  }