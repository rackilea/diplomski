public class ReadHdfsFile {

    public static void main(String[] args) throws IOException {

        Configuration conf = new Configuration();
        conf.addResource(new Path("/Users/miqbal1/hadoop-eco/hadoop-1.1.2/conf/core-site.xml"));
        conf.addResource(new Path("/Users/miqbal1/hadoop-eco/hadoop-1.1.2/conf/hdfs-site.xml"));
        FileSystem fs = FileSystem.get(conf);
        FSDataInputStream in = fs.open(new Path("/demo.txt"));

        //Filling the array b1 from the 5th byte
        int charPos = 0;
        byte[] b1 = new byte[10];
        int bytesRead = in.read(b1, 5, 5);
        System.out.println("Bytes Read : " + bytesRead);
        String s = new String(b1, "UTF-8");
        System.out.println("Printing char by char(you'll see first 5 bytes as blank)...");
        for(char c : s.toCharArray()){
            System.out.println("Character " + ++charPos + " : " + c);

        }
        System.out.println();
        System.out.println("Changing offset value....");

        //Filling the array b2 from the 10th byte
        in.seek(0);
        charPos = 0;
        byte[] b2 = new byte[15];
        bytesRead = in.read(b2, 10, 5);
        System.out.println("Bytes Read : " + bytesRead);
        s = new String(b2, "UTF-8");
        System.out.println("Printing char by char(you'll see first 10 bytes as blank)...");
        for(char c : s.toCharArray()){
            System.out.println("Character " + ++charPos + " : " + c);
        }

        System.out.println("DONE!!!");
        in.close();
        fs.close();
    }
}