public class SequenceFileReader {
    public static void main(String args[]) throws Exception {
        System.out.println("Readeing Sequence File");
        Configuration conf = new Configuration();
        conf.addResource(new Path("/home/mohammad/hadoop-0.20.203.0/conf/core-site.xml"));
        conf.addResource(new Path("/home/mohammad/hadoop-0.20.203.0/conf/hdfs-site.xml"));  
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("/seq/file");
        SequenceFile.Reader reader = null;      
        try {
            reader = new SequenceFile.Reader(fs, path, conf);
            Writable key = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(), conf);
            Writable value = (Writable) ReflectionUtils.newInstance(reader.getValueClass(), conf);
            while (reader.next(key, value)) {
                System.out.println(key + "  <===>  " + value.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(reader);
        }
    }
}