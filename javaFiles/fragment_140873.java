public class maxConsumption  extends Configured implements Tool{

    public static class DataMapper extends Mapper<Object, Text, Text, IntWritable> {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateInFile, filterDate;
        int lineno=0;
        private final static Text customer = new Text();
        private final static IntWritable consumption = new IntWritable();
        private final static Text maxConsumptionDate = new Text();

        public void setup(Context context) {
            Configuration config = context.getConfiguration();
            maxConsumptionDate.set(config.get("mapper.maxConsumption.date"));
        }

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
            try{
                lineno++;
                filterDate = ft.parse(maxConsumptionDate.toString());
                //map data from line/file
                String[] fields = value.toString().split(",");
                customer.set(fields[0].trim());
                dateInFile = ft.parse(fields[1].trim());
                consumption.set(Integer.parseInt(fields[2].trim()));

                if(dateInFile.equals(filterDate)) //only send to reducer if date filter matches....
                    context.write(new Text(customer), consumption);
            }catch(Exception e){
                System.err.println("Invaid Data at line: " + lineno + " Error: " + e.getMessage());
            }
        }   
    }

    public  static class DataReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        LinkedHashMap<String, Integer> maxConsumption = new LinkedHashMap<String,Integer>();
        @Override
        public void reduce(Text key, Iterable<IntWritable> values, Context context) 
                throws IOException, InterruptedException {
            int max=0;
            System.out.print("reducer received: " + key + " [ ");
            for(IntWritable value: values){
                System.out.print( value.get() + " ");
                if(value.get() > max)
                    max=value.get();
            }
            System.out.println( " ]");
            System.out.println(key.toString() + "    max is   " + max);
            maxConsumption.put(key.toString(), max);
        }

        @Override
        protected void cleanup(Context context)
                throws IOException, InterruptedException {
            int max=0;
            //first find the max from reducer
            for (String key : maxConsumption.keySet()){
                 System.out.println("cleaup customer : " + key.toString() + " consumption : " + maxConsumption.get(key) 
                         + " max: " + max); 
                if(maxConsumption.get(key) > max)
                    max=maxConsumption.get(key);
            }

            System.out.println("final max is: " + max);
            //write only the max value from map
            for (String key : maxConsumption.keySet()){
                if(maxConsumption.get(key) == max)
                    context.write(new Text(key), new IntWritable(maxConsumption.get(key)));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new maxConsumption(), args);
        System.exit(res);
    }

    public int run(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: -Dmapper.maxConsumption.date=\"2013-07-01 01:00:00\" <in> <out>");
            System.exit(2);
        }
        Configuration conf = this.getConf();
        Job job = Job.getInstance(conf, "get-max-consumption");
        job.setJarByClass(maxConsumption.class);
        job.setMapperClass(DataMapper.class);
        job.setReducerClass(DataReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        FileSystem fs = null;
        Path dstFilePath = new Path(args[1]);
        try {
            fs = dstFilePath.getFileSystem(conf);
            if (fs.exists(dstFilePath))
                fs.delete(dstFilePath, true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return job.waitForCompletion(true) ? 0 : 1;
    } 
}