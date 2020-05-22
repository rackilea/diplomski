import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;



String Dest = "/user/pkumar/test.xml";

 Configuration conf = new Configuration();
       FileSystem fs = FileSystem.get(URI.create(Dest),conf);
        Path path = new Path(Dest);

    if(!fs.exists(path)){
        OutputStream out = fs.create(path, new Progressable(){
            public void progress(){
                System.out.print(".");
            }
        });
        System.out.println();
        IOUtils.copyBytes(connect, out, 4096, true);
    }