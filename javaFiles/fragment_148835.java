public class HDFSClientTesting {

/**
 * @param args
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub

  try{

 //System.loadLibrary("libhadoop.so");
    Configuration conf = new Configuration();
    FileSystem fs = FileSystem.get(conf);
    conf.addResource(new Path("core-site.xml"));


    String Filename = "/dir/00000027";
    long ByteOffset = 3185041;



    SequenceFile.Reader rdr = new SequenceFile.Reader(fs, new Path(Filename), conf);
    Text key = new Text();
    Text value = new Text();

    rdr.seek(ByteOffset);
    rdr.next(key,value);
    //Plain text
    JSONObject jso = new JSONObject(value.toString());
    String content = jso.getString("body");
    System.out.println("\n\n\n" + content + "\n\n\n");

    File file =new File("test.gz");
    file.createNewFile();

}
  catch (Exception e ){
    throw new RuntimeException(e);

}
 finally{

 } 

  }

}