public static class IntSumReducer extends Reducer<Text,IntWritable,Text,IntWritable> {       
private IntWritable result = new IntWritable();

TreeMap<Text,IntWritable>result=new TreeMap<Text, IntWritable>();

public void reduce(Text key, Iterable<IntWritable> values,  Context context) throws IOException, InterruptedException {
  int sum = 0;
  for (IntWritable val : values) {
    sum += val.get();
  }
 result.put(new Text(key),new IntWritable(sum));
}
}

    @Override
    protected void cleanup(Context context)
            throws IOException, InterruptedException {

        Set<Entry<Text, IntWritable>> set = result.entrySet();
        List<Entry<Text, IntWritable>> list = new ArrayList<Entry<Text,IntWritable>>(set);
        Collections.sort( list, new Comparator<Map.Entry<Text, IntWritable>>()
        {
            public int compare( Map.Entry<Text, IntWritable> o1, Map.Entry<Text,IntWritable> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        });
        for(Map.Entry<Text,IntWritable> entry:list){

            context.write(entry.getKey(),entry.getValue());
        }

    }
    }