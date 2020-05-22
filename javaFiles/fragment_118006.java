public static class Map extends MapReduceBase implements
            Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void configure(JobConf job) {
       for (MSLiteThread thread : Threads) {
         System.out.println("created thread");
         thread = new MSLiteThread(pile);
         thread.start();
       }
    }

    @Override
    public void map(LongWritable key, Text value,
       OutputCollector<Text, Text> output, Reporter reporter) {
    }

}