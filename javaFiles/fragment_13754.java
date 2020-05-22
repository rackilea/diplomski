import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.LineRecordReader;
import org.apache.hadoop.mapred.RecordReader;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.lib.CombineFileInputFormat;
import org.apache.hadoop.mapred.lib.CombineFileRecordReader;
import org.apache.hadoop.mapred.lib.CombineFileSplit;

@SuppressWarnings("deprecation")
public class CombinedInputFormat extends CombineFileInputFormat<LongWritable, Text> {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public RecordReader<LongWritable, Text> getRecordReader(InputSplit split, JobConf conf, Reporter reporter) throws IOException {

        return new CombineFileRecordReader(conf, (CombineFileSplit) split, reporter, (Class) myCombineFileRecordReader.class);
    }

    public static class myCombineFileRecordReader implements RecordReader<LongWritable, Text> {
        private final LineRecordReader linerecord;

        public myCombineFileRecordReader(CombineFileSplit split, Configuration conf, Reporter reporter, Integer index) throws IOException {
            FileSplit filesplit = new FileSplit(split.getPath(index), split.getOffset(index), split.getLength(index), split.getLocations());
            linerecord = new LineRecordReader(conf, filesplit);
        }

        @Override
        public void close() throws IOException {
            linerecord.close();

        }

        @Override
        public LongWritable createKey() {
            // TODO Auto-generated method stub
            return linerecord.createKey();
        }

        @Override
        public Text createValue() {
            // TODO Auto-generated method stub
            return linerecord.createValue();
        }

        @Override
        public long getPos() throws IOException {
            // TODO Auto-generated method stub
            return linerecord.getPos();
        }

        @Override
        public float getProgress() throws IOException {
            // TODO Auto-generated method stub
            return linerecord.getProgress();
        }

        @Override
        public boolean next(LongWritable key, Text value) throws IOException {

            // TODO Auto-generated method stub
            return linerecord.next(key, value);
        }

    }
}