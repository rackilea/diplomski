package org.undercloud.mapreduce.example3;

import java.io.*;

import org.apache.hadoop.io.*;

public class XmlContent implements Writable{

    public byte[] bufferData;
    public int offsetData;
    public int lenghtData;


      public XmlContent(byte[] bufferData, int offsetData, int lenghtData) {
          this.bufferData = bufferData;
          this.offsetData = offsetData;
          this.lenghtData = lenghtData;
          }

      public XmlContent(){
          this(null,0,0);
      }

      public void write(DataOutput out) throws IOException {
          out.write(bufferData);
          out.writeInt(offsetData);
          out.writeInt(lenghtData);
      }

      public void readFields(DataInput in) throws IOException {
          in.readFully(bufferData);
          offsetData = in.readInt();
          lenghtData = in.readInt();
          }

      public String toString() {
            return Integer.toString(offsetData) + ", "
                + Integer.toString(lenghtData) +", "
                + bufferData.toString();
          }   

}