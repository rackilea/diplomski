public class ReduceTask extends Reducer<Text,Text, Text, NullWritable>{

    public void reduce(Text key,Iterable<Text> values,Context context){

        for(Text value:values){
            try {
                context.write(key,NullWritable.get());
            } catch (IOException e) {

                e.printStackTrace();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }
}