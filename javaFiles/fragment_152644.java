public class Counter implements Writable {

       private float sum;
       private long count;

       public Counter(float sum, long count){
              this.sum = sum;
              this.count = count;
       }

       /* Methods to get and set private variables of the class */

       public float getSum() {
              return sum;
       }

       public void setSum(float sumValue) {
              sum=sumValue;
       }

       public long getCount() {
              return count;
       }

       public void setCount(long countValue) {
              count=countValue;
       }

       /* Methods to serialize and deserialize the contents of the
          instances of this class */

       @Override /* Serialize the fields of this object to out */ 
       public void write(DataOutput out) throws IOException{
              out.writeFloat(sum);
              out.writeLong(count);
       }

      @Override /* Deserialize the fields of this object from in */
      public void readFields(DataInputin) throws IOException{
                  sum=in.readFloat();
                  count=in.readLong();
       }
       }