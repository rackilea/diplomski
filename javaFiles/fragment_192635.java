import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
...
public class KnnPattern
{
  ...
    public static void main(String[] args) throws Exception {
        // Create configuration
        Configuration conf = new Configuration();

        if (args.length != 3) {
            System.err.println("Usage: KnnPattern <in> <out> <parameter file>");
            System.exit(2);
        }

        try (final BufferedReader br = new BufferedReader(new FileReader(args[2]))) {
            int n = 1;
            String line;
            while ((line = br.readLine()) != null) {
                // create temporary file with content of current line
                final File tmpDataFile = File.createTempFile("hadoop-test-", null);
                try (BufferedWriter tmpDataWriter = new BufferedWriter(new FileWriter(tmpDataFile))) {
                    tmpDataWriter.write(line);
                    tmpDataWriter.flush();
                }

                // Create job
                Job job = Job.getInstance(conf, "Find K-Nearest Neighbour #" + n);
                job.setJarByClass(KnnPattern.class);
                // Set the third parameter when running the job to be the parameter file and give it an alias
                job.addCacheFile(new URI(tmpDataFile.getAbsolutePath() + "#knnParamFile")); // Parameter file containing test data

                // Setup MapReduce job
                job.setMapperClass(KnnMapper.class);
                job.setReducerClass(KnnReducer.class);
                job.setNumReduceTasks(1); // Only one reducer in this design

                // Specify key / value
                job.setMapOutputKeyClass(NullWritable.class);
                job.setMapOutputValueClass(DoubleString.class);
                job.setOutputKeyClass(NullWritable.class);
                job.setOutputValueClass(Text.class);

                // Input (the data file) and Output (the resulting classification)
                FileInputFormat.addInputPath(job, new Path(args[0]));
                FileOutputFormat.setOutputPath(job, new Path(args[1] + "_" + n));

                // Execute job
                final boolean jobSucceeded = job.waitForCompletion(true);

                // clean up
                tmpDataFile.delete();

                if (!jobSucceeded) {
                    // return error status if job failed
                    System.exit(1);
                }

                ++n;
            }
        }
    }

}