import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class TestMapper extends     
Mapper<LongWritable,Text,IntWritable,IntWritable> {

private IntWritable date_int = new IntWritable();
private IntWritable amount_int = new IntWritable(); 

/**
 * @param key      - Line offset - ignored.
 * @param value    - Value to process.
 * @param context  - MapperContext object for accessing output, configuration         information, etc.
 * @throws IOException, InterruptedException. 
 */
@Override
public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException 
    {
    String date_str = value.toString().substring(4,5);
    String amount_str = value.toString().substring(7,8);
    int date = Integer.parseInt(date_str);
    date_int.set(date);
    int amount = Integer.parseInt(amount_str);
    amount_int.set(amount);
    // Sammeln der Ergebnisse
    context.write(date_int, amount_int);
    }
}