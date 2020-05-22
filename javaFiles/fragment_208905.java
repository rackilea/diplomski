import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.ReflectionUtils;

public class ArrayTextOutputFormat<K, V> extends TextOutputFormat<K, V> {

protected static class ArrayLineRecordWriter<K, V> extends
        LineRecordWriter<K, V> {


    private static final String utf8 = "UTF-8";
    private final byte[] arraySeparator;
    private final byte[] keyValueSeparator;
    private final byte[] lineSeparator;

    public ArrayLineRecordWriter(DataOutputStream out,
            String keyValueSeparator, String arraySeparator, String lineSeparator) {
        super(out);
        try {
            this.keyValueSeparator = keyValueSeparator.getBytes(utf8);
            this.arraySeparator = arraySeparator.getBytes(utf8);
            this.lineSeparator = lineSeparator.getBytes(utf8);
        } catch (UnsupportedEncodingException uee) {
            throw new IllegalArgumentException("can't find " + utf8
                    + " encoding");
        }
    }

    private void writeObject(Object o) throws IOException {
        if (o instanceof Text) {
            Text to = (Text) o;
            out.write(to.getBytes(), 0, to.getLength());
        } else if (o instanceof ArrayWritable) {
            ArrayWritable awo = (ArrayWritable) o;
            for (String wrt : awo.toStrings()) {
                out.write(wrt.toString().getBytes(utf8));
                out.write(arraySeparator);
            }
        } else {
            out.write(o.toString().getBytes(utf8));
        }
    }

    public synchronized void write(K key, V value) throws IOException {

        boolean nullKey = key == null || key instanceof NullWritable;
        boolean nullValue = value == null || value instanceof NullWritable;
        if (nullKey && nullValue) {
            return;
        }
        if (!nullKey) {
            writeObject(key);
        }
        if (!(nullKey || nullValue)) {
            out.write(keyValueSeparator);
        }
        if (!nullValue) {
            writeObject(value);
        }
        out.write(lineSeparator);
    }
}

public RecordWriter<K, V> getRecordWriter(TaskAttemptContext job)
        throws IOException, InterruptedException {
    Configuration conf = job.getConfiguration();
    boolean isCompressed = getCompressOutput(job);
    String keyValueSeparator = conf.get(
            "mapred.textoutputformat.separator", "\t");
    String arraySeparator = conf.get("mapred.arraywritable.separator", "|");
    String lineSeparator = conf.get("mapred.line.separator");
    CompressionCodec codec = null;
    String extension = "";
    if (isCompressed) {
        Class<? extends CompressionCodec> codecClass = getOutputCompressorClass(
                job, GzipCodec.class);
        codec = (CompressionCodec) ReflectionUtils.newInstance(codecClass,
                conf);
        extension = codec.getDefaultExtension();
    }
    Path file = getDefaultWorkFile(job, extension);
    FileSystem fs = file.getFileSystem(conf);
    if (!isCompressed) {
        FSDataOutputStream fileOut = fs.create(file, false);
        return new ArrayLineRecordWriter<K, V>(fileOut, keyValueSeparator,
                arraySeparator, lineSeparator);
    } else {
        FSDataOutputStream fileOut = fs.create(file, false);
        return new ArrayLineRecordWriter<K, V>(new DataOutputStream(
                codec.createOutputStream(fileOut)), keyValueSeparator,
                arraySeparator, lineSeparator);
    }
}
}