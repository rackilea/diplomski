public class MyMap extends Mapper<LongWritable, Text, Text, DblArrayWritable> 
{
  public void map(LongWritable key, Text value, Context context) throws IOException 
  {

    String line = value.toString();
    String[] attribute=line.split(",");
    DoubleWritable[] values = new DoubleWritable[2];
    values[0] = Double.parseDouble(attribute[14]);
    values[1] = Double.parseDouble(attribute[17]);

    String comb=new String();
    comb=attribute[5].concat(attribute[8].concat(attribute[10]));

    context.write(new Text(comb),new DblArrayWritable.set(values));

  }
}