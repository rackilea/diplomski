public class TermProjectReducer extends Reducer < Text, IntWritable, Text, IntWritable > 
{ 
  private IntWritable result = new IntWritable(); 

  @Override
    public void reduce( Text key, Iterable < IntWritable > values, Context context) throws IOException, InterruptedException 
    { 
        int total = 0; 
        int good_sum = 0;
        for (IntWritable val : values) 
        { 
            good_sum += (val.get() == 1 ? 1 : 0); 
            total += 1
        } 
        if (total > 0) // Prevent division by zero
        {
            double percent = 1.0*good_sum/total;
            // Round it to how every many decimal places, if you want
            result.set(String.valueOf(percent)); // convert the floating number to a string
        } else {
            result.set("0.00"); 
        }
        context.write(key, result); 
    } 
}