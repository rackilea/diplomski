public static class Reduce extends Reducer<Text, Writable, Text, Writable> {

  static ArrayList<String> files;
  static String[] top5;
  static int[] counttop5;
  int reducedterms;

  //setup method instead of configure
  public void setup(Context context){
          files= new ArrayList<String>();
          top5=new String[5];
          reducedterms=0; 
          counttop5=new int[5];
  }

  //In cleanup you may access the write method
  @Override 
  public void cleanup(Context context){
         // Use top5 and counttop5 the way you see fit
         // Use context.write() to pass them ahead!
  }

      public void reduce(Text key, Iterator<Writable> values, Context context) throws IOException {
}