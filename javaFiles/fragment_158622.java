import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;


public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException, URISyntaxException
    {
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.addCacheFile(new Path("").toUri());
    }
}