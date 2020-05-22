public class StMApper extends Mapper<LongWritable,Text,Text,Text>
{
Text outkey-new Text();
Text outvalue=new Text();

public void map(LongWritable key,Text values, Context context)
{
    //Alex 19 M NJ
    String []col=values.toString().split(" ");
    outkey.set(cols[0]);
    outvalue.set(values.toString());
    context.write(outkey,outvalue);
}
}

public class StReducer extends Reducer<Text,Text,IntWritable,Text>
{
IntWritable outkey=new IntWritable();
Text outvalue=new Text();
    ////Alex{Alex 19 M NJ , Alex 29 M DC,...}
public void reduce(Text key,Iterable<Text> values,Context context)
{   
    int i=0;
    for(Text val:values)
    {
        outkey.set(i);
        outvalue.set(val);
        i++;
        context.write(outkey,outvalue);
    }
 }
}