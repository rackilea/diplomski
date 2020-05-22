public class YourReducer extends TableReducer<Text, Text, Text> {    
private byte[] rawUpdateColumnFamily = Bytes.toBytes("colName");
/**
* Called once at the beginning of the task.
*/
@Override
protected void setup(Context context) throws IOException, InterruptedException {
// something that need to be done at start of reducer
}

@Override
public void reduce(Text keyin, Iterable<Text> values, Context context) throws IOException, InterruptedException {
// aggregate counts
int valuesCount = 0;
for (Text val : values) {
   valuesCount += 1;
   // put date in table
   Put put = new Put(keyin.toString().getBytes());
   long explicitTimeInMs = new Date().getTime();
   put.add(rawUpdateColumnFamily, Bytes.toBytes("colName"), explicitTimeInMs,val.toString().getBytes());
   context.write(keyin, put);


      }
    }
}