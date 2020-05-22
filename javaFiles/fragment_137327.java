public class FileToUserVectorReducer 
        extends Reducer<VarLongWritable, VarLongWritable, VarLongWritable, VectorWritable> {
    @Override
    public void reduce(VarLongWritable userID, Iterable<VarLongWritable> itemPrefs, Context context)
        throws IOException, InterruptedException{
        Vector userVector = new RandomAccessSparseVector(Integer.MAX_VALUE, 100);
        for(VarLongWritable itemPref : itemPrefs){
            userVector.set((int)itemPref.get(), 1.0f);
        }
        context.write(userID, new VectorWritable(userVector));
    }
}