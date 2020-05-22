package org.undercloud.mapreduce.example3;

import java.io.IOException;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class XmlRecordReader implements RecordReader {

    private String startTagS = "";
    private String endTagS = "";
    private byte[] startTag;
    private byte[] endTag;
    private long start;
    private long end;
    private FSDataInputStream fsin;
    private DataOutputBuffer buffer = new DataOutputBuffer();
    private LineRecordReader lineReader;
    private LongWritable lineKey;
    private Text lineValue;

    public XmlRecordReader(JobConf job, FileSplit split) throws IOException {
      lineReader = new LineRecordReader(job, split);
      lineKey = lineReader.createKey();
      lineValue = lineReader.createValue();
      startTag = startTagS.getBytes();
      endTag = endTagS.getBytes();

      // Open the file and seek to the start of the split
      start = split.getStart();
      end = start + split.getLength();
      Path file = split.getPath();
      FileSystem fs = file.getFileSystem(job);
      fsin = fs.open(split.getPath());
      fsin.seek(start);
   }

    public boolean next(Text key, XmlContent value) throws IOException {
    // Get the next line
        if (fsin.getPos() < end) { 
            if (readUntilMatch(startTag, false)) { 
                try { 
                    buffer.write(startTag); 
                    if (readUntilMatch(endTag, true)) { 
                        key.set(Long.toString(fsin.getPos())); 
                        value.bufferData = buffer.getData(); 
                        value.offsetData = 0; 
                        value.lenghtData = buffer.getLength(); 
                        return true; 
                    } 
                } 
                finally { 
                    buffer.reset(); 
                } 
            } 
        } 
        return false; 
    } 

    private boolean readUntilMatch(byte[] match, boolean withinBlock) throws IOException { 
        int i = 0; 
        while (true) { 
            int b = fsin.read(); // End of file -> T
            if (b == -1) return false;
            // F-> Save to buffer:
            if (withinBlock) buffer.write(b);
            if (b == match[i]) {
                i++;
                if (i >= match.length) return true;
            } else i = 0;
            // see if we’ve passed the stop point:
            if(!withinBlock && i == 0 && fsin.getPos() >= end) return false;
        }
    }

  public Text createKey() {
     return new Text("");
  }

  public XmlContent createValue() {
    return new XmlContent();
  }

  public long getPos() throws IOException {
    return lineReader.getPos();
  }

  public void close() throws IOException {
    lineReader.close();
  }

  public float getProgress() throws IOException {
    return lineReader.getProgress();
  }
}