import java.io.IOException;

import org.apache.hadoop.fs.FSDataInputStream; import
org.apache.hadoop.fs.FileStatus; import
org.apache.hadoop.fs.FileSystem; import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text; import
org.apache.hadoop.mapreduce.InputSplit; import
org.apache.hadoop.mapreduce.RecordReader; import
org.apache.hadoop.mapreduce.TaskAttemptContext; import
org.apache.hadoop.mapreduce.lib.input.FileSplit; import
org.apache.spark.deploy.SparkHadoopUtil;

public class RichFileRecordReader extends RecordReader<Text,
FileInfoWritable> {     private String author;  private String
createdDate;    private String owner;   private String lastModified;
    private String content;     private boolean processed;

    private Text key;   private Path path;  private FileSystem fs;

    public RichFileRecordReader() {

    }

    @Override   public void initialize(InputSplit split,
TaskAttemptContext context) throws IOException, InterruptedException
{       // this.recordReader.initialize(split, context);        final
FileSplit fileSplit = (FileSplit) split;        final Path path =
fileSplit.getPath();        this.fs =
path.getFileSystem(SparkHadoopUtil.get().getConfigurationFromJobContext(context));
        final FileStatus stat = this.fs.getFileStatus(path);        this.path =
path;       this.author = stat.getOwner();      this.createdDate =
String.valueOf(stat.getModificationTime());         this.lastModified =
String.valueOf(stat.getAccessTime());       this.key = new
Text(path.toString());  }

    @Override   public boolean nextKeyValue() throws IOException,
InterruptedException {      // TODO Auto-generated method stub
        FSDataInputStream stream = null;        try {           if (!processed) {
                int len = (int) this.fs.getFileStatus(this.path).getLen();
                final byte[] data = new byte[len];

                stream = this.fs.open(this.path);
                int read = stream.read(data);
                String content = new String(data, 0, read);
                this.content = content;
                processed = true;
                return true;            }       } catch (IOException e) {           e.printStackTrace();            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }           }       }       return false;   }

    @Override   public Text getCurrentKey() throws IOException,
InterruptedException {      // TODO Auto-generated method stub      return
this.key;   }

    @Override   public FileInfoWritable getCurrentValue() throws
IOException, InterruptedException {         // TODO Auto-generated method
stub

        final FileInfoWritable fileInfo = new FileInfoWritable();
        fileInfo.setContent(this.content);
        fileInfo.setAuthor(this.author);
        fileInfo.setCreatedDate(this.createdDate);
        fileInfo.setOwner(this.owner);
        fileInfo.setPath(this.path.toString());         return fileInfo;    }

    @Override   public float getProgress() throws IOException,
InterruptedException {      // TODO Auto-generated method stub      return
processed ? 1.0f : 0.0f;    }

    @Override   public void close() throws IOException {        // TODO
Auto-generated method stub

    }

}