public interface Writable {

       public void write(DataOutput out) throws IOException;

       public void readFields(DataInput in) throws IOException;
}