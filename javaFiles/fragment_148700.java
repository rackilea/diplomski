import org.apache.hadoop.io.IOUtils;
//import org.apache.commons.io.IOUtils;
import java.io.*;
import java.net.URI;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;

public class ReaderHDFS {
    public static void main(String[] args) throws IOException {

        String uri = args[0];

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        FSDataInputStream in = null ;

        try
        {
            in = fs.open(new Path(uri));
            IOUtils.copyBytes(in, System.out, 4096, false);
        }
        finally
        {
            IOUtils.closeStream(in);
        }   
    }
}