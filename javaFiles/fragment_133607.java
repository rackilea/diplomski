public final class ExampleSpark {

    public static void main(String[] args) throws Exception {
        JavaSparkContext spark = new JavaSparkContext();
        Configuration jobConf = new Configuration();

        JavaPairRDD<LongWritable, Text> inputRDD = spark.newAPIHadoopFile(args[0], TextInputFormat.class, LongWritable.class, Text.class, jobConf);
        System.out.println(inputRDD.count());

        spark.stop();
        System.exit(0);
    }
}